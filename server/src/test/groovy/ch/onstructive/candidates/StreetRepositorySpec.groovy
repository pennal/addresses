/* Licensed under Apache-2.0 */
package ch.onstructive.candidates

import io.micronaut.test.annotation.MicronautTest
import spock.lang.Specification
import spock.lang.Stepwise

import javax.inject.Inject

@Stepwise
@MicronautTest(rollback = false)
class StreetRepositorySpec extends Specification {

	@Inject
	StreetRepository streetRepository;

	@Inject
	PostalCodeRepository postalCodeRepository

	void "Create a street"() {
		when:
		// We need to also create a postal code first
		PostalCode lugano = new PostalCode(postalCode: 6900, displayName: "Lugano")
		lugano = postalCodeRepository.save(lugano)


		Street street = new Street(name: "Via Gerso", houseNumber: 3, postalCode: lugano)
		street = streetRepository.save(street);

		then:
		street.id != null

		and:
		street.version == 0
	}

	void "Update a street"() {
		when:
		Street street = streetRepository.findAll().first()
		street.setName("Via Zurigo")
		street.setHouseNumber(11 as Short)
		Long oldNumber = street.getPostalCode().getId()
		streetRepository.update(street.getId(), street.getName(), street.getHouseNumber(), street.getPostalCode().getId())
		then:
		street.name == 'Via Zurigo'
		street.houseNumber == 11 as Short
		street.postalCode.id === oldNumber
	}


	void "Delete streets"() {

		given:
		streetRepository.deleteAll()

		expect:
		streetRepository.count() == 0
	}
}
