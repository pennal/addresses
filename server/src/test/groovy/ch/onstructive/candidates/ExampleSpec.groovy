/* Licensed under Apache-2.0 */
package ch.onstructive.candidates

import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.annotation.MicronautTest
import spock.lang.Specification
import javax.inject.Inject

/**
 * This is a simple example of a Spock test.
 */
@MicronautTest
class ExampleSpec extends Specification {

	@Inject
	EmbeddedApplication application

	void "test it works"() {
		expect:
		application.running
	}
}
