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

	void "There are should be now only one postal code present"() {

		given: 'fetch all available postal codes'
		List<PostalCodeController.PostalCodeGetModel> postalCodes =  controller.findAllPostalCodes()

		expect:
		postalCodes.size() == 1

		and:
		with(postalCodes.first()) {
			id > 0L
			postalCode == 9015 as Short
			name == 'St. Gallen'
		}
	}
}
