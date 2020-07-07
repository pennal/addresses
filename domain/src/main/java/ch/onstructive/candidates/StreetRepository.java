/* Licensed under Apache-2.0 */
package ch.onstructive.candidates;

import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository
public interface StreetRepository extends JpaRepository<Street, Long> {
  @Query(
      value =
          "UPDATE Street SET name=:name, houseNumber=:houseNumber, postalCode_id=:postalCodeId WHERE id=:id",
      nativeQuery = true)
  Street update(Long id, String name, Short houseNumber, Long postalCodeId);
}
