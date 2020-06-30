/* Licensed under Apache-2.0 */
package ch.onstructive.candidates

import io.micronaut.test.annotation.MicronautTest
import spock.lang.Specification
import spock.lang.Stepwise

import javax.inject.Inject

/**
 * A simple test to explain how to work with Micronaut Data repositories.
 *
 * @author Silvio Wangler (silvio.wangler@onstructive.ch)
 */
@Stepwise
@MicronautTest(rollback = false)
class PostalCodeRepositorySpec extends Specification {

	@Inject
	PostalCodeRepository postalCodeRepository

	void "Create a postal code"() {

		given:
		PostalCode zurich = new PostalCode(postalCode: 8047 as Short, displayName: 'Zürich')

		when:
		zurich = postalCodeRepository.save(zurich)

		then:
		zurich.id != null

		and:
		zurich.version == 0
	}

	void "Find postal code 8047"() {

		when:
		PostalCode zurich = postalCodeRepository.findByPostalCode(8047 as Short)

		then:
		zurich

		and:
		zurich.version == 0
	}

	void "Delete postal codes"() {

		given:
		postalCodeRepository.deleteAll()

		expect:
		postalCodeRepository.count() == 0
	}
}
