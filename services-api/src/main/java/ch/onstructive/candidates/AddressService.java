/* Licensed under Apache-2.0 */
package ch.onstructive.candidates;

import java.util.List;

/**
 * API service for working with the Swiss address directory.
 *
 * @author Silvio Wangler (silvio.wangler@onstructive.ch)
 */
public interface AddressService {

  List<PostalCodeDTO> findAllPostalCodes();

  PostalCodeDTO createPostalCode(PostalCodeDTO postalCode);
}
