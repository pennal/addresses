/* Licensed under Apache-2.0 */
package ch.onstructive.candidates;

import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

/**
 * Repository for {@link PostalCode}.
 *
 * @author Silvio Wangler (silvio.wangler@onstructive.ch)
 */
@Repository
public interface PostalCodeRepository extends JpaRepository<PostalCode, Long> {
  PostalCode findByPostalCode(Short postalCode);

  @Query(value = "UPDATE PostalCode SET displayName=:displayName, postalCode=:postalCode WHERE id=:id", nativeQuery = true)
  PostalCode update(Long id, String displayName, Short postalCode);
}
