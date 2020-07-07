/* Licensed under Apache-2.0 */
package ch.onstructive.candidates

import io.micronaut.http.HttpStatus
import io.micronaut.test.annotation.MicronautTest
import spock.lang.Specification
import spock.lang.Stepwise
import spock.lang.Subject

import javax.inject.Inject

@MicronautTest(rollback = false)
@Stepwise
class StreetControllerSpec extends Specification {

	@Inject
	@Subject
	StreetController controller

	@Inject
	@Subject
	PostalCodeController postalCodeController

	void "There are no streets present"() {
		expect:
		controller.findAllStreets().isEmpty()
	}

	void "Create a Street with invalid parameters"() {
		when:
		controller.create(new StreetController.StreetPostModel(name: "Test", houseNumber: 0, postalCodeId: 12345))
		then:
		thrown(NotFoundException)
	}

	void "Create a new street"() {
		when:
		HttpStatus httpStatus = postalCodeController.create(new PostalCodeController.PostalCodePostModel(postalCode: 6900 as Short, name: "Lugano"))

		then:
		httpStatus == HttpStatus.CREATED

		// First we need to create the postal code
		when:
		HttpStatus streetCreate = controller.create(new StreetController.StreetPostModel(name: "Via Gerso", houseNumber: 3, postalCodeId: 1))
		then:
		streetCreate == HttpStatus.CREATED
	}

	void "There is only one Street present"() {

		when: 'fetch all available streets'
		List<StreetController.StreetGetModel> streets = controller.findAllStreets()

		then:
		streets.size() == 1

		and:
		with(streets.first()) {
			id > 0L
			name == 'Via Gerso'
			houseNumber == 3
			postalCode.id != null
		}

		when:
		StreetController.StreetGetModel street = controller.findStreetById(streets.first().id)

		then:
		street == streets.first()

		when:
		controller.findStreetById(28378L)

		then:
		thrown(NotFoundException)
	}

	void "Update a street"() {
		when:
		StreetController.StreetGetModel street = controller.findAllStreets().first()
		StreetController.StreetGetModel updatedStreet = controller.updateStreet(new StreetController.StreetPutModel(id: street.getId(), name: "Changed", houseNumber: 1, postalCodeId: street.getPostalCode().getId()))
		then:
		updatedStreet.id == street.id
		updatedStreet.name == 'Changed'
		updatedStreet.houseNumber == 1
		street.postalCode.id == updatedStreet.postalCode.id
		street.postalCode.displayName == updatedStreet.postalCode.displayName


		// We try one with a wrong id for the postal code
		when:
		controller.updateStreet(new StreetController.StreetPutModel(id: street.getId(), name: "Changed", houseNumber: 1, postalCodeId: 12345))
		then:
		thrown(NotFoundException)
	}
}
