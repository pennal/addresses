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
class PostalCodeControllerSpec extends Specification {

	@Inject
	@Subject
	PostalCodeController controller

	void "There are no postal codes present"() {

		expect:
		controller.findAllPostalCodes().isEmpty()
	}

	void "Create a new postal code"() {

		when:
		HttpStatus httpStatus = controller.create(new PostalCodeController.PostalCodePostModel(postalCode: 9015 as Short, name: 'St. Gallen'))

		then:
		httpStatus == HttpStatus.CREATED
	}

	void "Update a postal code"() {
		// First create
		when:
			HttpStatus httpStatus = controller.create(new PostalCodeController.PostalCodePostModel(postalCode: 6900 as Short, name: 'Lugano'))

		then:
			httpStatus == HttpStatus.CREATED

		// Then modify and update
		when:
			PostalCodeController.PostalCodeGetModel updated = controller.update(new PostalCodeController.PostalCodePutModel(postalCode: 6900, name: "Lugano Massagno", id: 1))
		then:
			updated.id == 1
			updated.postalCode == 6900
			updated.name == 'Lugano Massagno'
	}

	void "There are should be now only one postal code present"() {

		when: 'fetch all available postal codes'
		List<PostalCodeController.PostalCodeGetModel> postalCodes = controller.findAllPostalCodes()

		then:
		postalCodes.size() == 1

		and:
		with(postalCodes.first()) {
			id > 0L
			postalCode == 9015 as Short
			name == 'St. Gallen'
		}

		when:
		PostalCodeController.PostalCodeGetModel postalCode = controller.findPostalCode(postalCodes.first().id)

		then:
		postalCode == postalCodes.first()

		when:
		controller.findPostalCode(28378L)

		then:
		thrown(NotFoundException)
	}
}
