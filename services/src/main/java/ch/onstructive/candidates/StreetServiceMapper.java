/* Licensed under Apache-2.0 */
package ch.onstructive.candidates;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = "jsr330",
    unmappedTargetPolicy = ReportingPolicy.ERROR,
    uses = {AddressServiceMapper.class})
public interface StreetServiceMapper {
  @Mapping(source = "postalCode", target = "postalCodeDTO")
  StreetDTO toStreetDTO(Street street);

  List<StreetDTO> toStreetDTOs(List<Street> allStreets);

  @Mapping(source = "postalCodeDTO", target = "postalCode")
  Street toStreet(StreetDTO streetDTO);
}
