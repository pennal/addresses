/* Licensed under Apache-2.0 */
package ch.onstructive.candidates;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

/**
 * Mapper for transforming the API of {@link AddressService} into the REST controllers model.
 *
 * @author Silvio Wangler (silvio.wangler@onstructive.ch)
 */
@Mapper(componentModel = "jsr330", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface PostalCodeControllerMapper {

  @Mapping(target = "name", source = "displayName")
  PostalCodeController.PostalCodeGetModel toPostalCodeGetModel(PostalCodeDTO postalCode);

  List<PostalCodeController.PostalCodeGetModel> toPostalCodeGetModels(
      List<PostalCodeDTO> postalCodes);

  @Mapping(target = "displayName", source = "name")
  @Mapping(target = "id", ignore = true)
  @Mapping(target = "version", ignore = true)
  PostalCodeDTO toPostalCodeDTO(PostalCodeController.PostalCodePostModel model);
}
