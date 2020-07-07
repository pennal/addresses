package ch.onstructive.candidates;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "jsr330", unmappedTargetPolicy = ReportingPolicy.ERROR, uses = { PostalCodeControllerMapper.class})
public interface StreetControllerMapper {

    @Mapping(source = "postalCodeDTO", target = "postalCode")
    StreetController.StreetGetModel toStreetGetModel(StreetDTO street);

    List<StreetController.StreetGetModel> toStreetGetModels(List<StreetDTO> streets);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "postalCodeDTO", ignore = true)
    StreetDTO toStreetDTO(StreetController.StreetPostModel model);

    @Mapping(target = "version", ignore = true)
    @Mapping(target = "postalCodeDTO", ignore = true)
    StreetDTO toStreetDTO(StreetController.StreetPutModel model);
}