/* Licensed under Apache-2.0 */
package ch.onstructive.candidates;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for transforming the API of {@link AddressService} into the REST controllers model.
 *
 * @author Silvio Wangler (silvio.wangler@onstructive.ch)
 */
@Mapper(componentModel = "jsr330")
public interface PostalCodeControllerMapper {

  @Mapping(target = "name", source = "displayName")
  PostalCodeController.PostalCodeGetModel toPostalCodeGetModel(PostalCodeDTO postalCode);

  List<PostalCodeController.PostalCodeGetModel> toPostalCodeGetModels(
      List<PostalCodeDTO> postalCodes);

  @Mapping(target = "displayName", source = "name")
  PostalCodeDTO toPostalCodeDTO(PostalCodeController.PostalCodePostModel model);
}
