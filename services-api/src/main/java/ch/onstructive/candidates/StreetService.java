package ch.onstructive.candidates;

import java.util.List;
import java.util.Optional;

public interface StreetService {
    List<StreetDTO> findAllStreets();

    StreetDTO createStreet(StreetDTO streetDTO, PostalCodeDTO postalCodeDTO);

    StreetDTO update(StreetDTO current, StreetDTO updated);

    Optional<StreetDTO> find(Long id);
}