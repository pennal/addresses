/* Licensed under Apache-2.0 */
package ch.onstructive.candidates;

import java.util.List;
import java.util.Optional;

/**
 * API service for working with the Swiss address directory.
 *
 * @author Silvio Wangler (silvio.wangler@onstructive.ch)
 */
public interface AddressService {

  List<PostalCodeDTO> findAllPostalCodes();

  PostalCodeDTO createPostalCode(PostalCodeDTO postalCode);

  PostalCodeDTO updatePostalCode(PostalCodeDTO current, PostalCodeDTO updated);

  Optional<PostalCodeDTO> find(Long id);
}
