package ch.onstructive.candidates;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "jsr330", unmappedTargetPolicy = ReportingPolicy.ERROR, uses={AddressServiceMapper.class})
public interface StreetServiceMapper {
    @Mapping(source = "postalCode", target = "postalCodeDTO")
    StreetDTO toStreetDTO(Street street);

    List<StreetDTO> toStreetDTOs(List<Street> allStreets);

    @Mapping(source = "postalCodeDTO", target = "postalCode")
    Street toStreet(StreetDTO streetDTO);
}
