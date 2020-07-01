/* Licensed under Apache-2.0 */
package ch.onstructive.candidates;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * Mapper for transforming JPA entities into the API types of {@link AddressService}.
 *
 * @author Silvio Wangler (silvio.wangler@onstructive.ch)
 */
@Mapper(componentModel = "jsr330", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface AddressServiceMapper {

  PostalCodeDTO toPostalCodeDTO(PostalCode postalCode);

  List<PostalCodeDTO> toPostalCodeDTOs(List<PostalCode> allPostalCodes);

  PostalCode toPostalCode(PostalCodeDTO postalCode);
}
