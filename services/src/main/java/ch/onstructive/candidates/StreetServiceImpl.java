/* Licensed under Apache-2.0 */
package ch.onstructive.candidates;

import java.util.List;
import java.util.Optional;

import javax.inject.Singleton;

@Singleton
public class StreetServiceImpl implements StreetService {
  private final StreetRepository streetRepository;
  private final StreetServiceMapper streetServiceMapper;

  private final AddressServiceMapper addressServiceMapper;

  public StreetServiceImpl(
      StreetRepository streetRepository,
      StreetServiceMapper streetServiceMapper,
      AddressServiceMapper addressServiceMapper) {
    this.streetRepository = streetRepository;
    this.streetServiceMapper = streetServiceMapper;
    this.addressServiceMapper = addressServiceMapper;
  }

  @Override
  public List<StreetDTO> findAllStreets() {
    List<Street> allStreets = this.streetRepository.findAll();
    return this.streetServiceMapper.toStreetDTOs(allStreets);
  }

  @Override
  public StreetDTO createStreet(StreetDTO streetDTO, PostalCodeDTO postalCodeDTO) {
    Street street = streetServiceMapper.toStreet(streetDTO);
    PostalCode postalCode = addressServiceMapper.toPostalCode(postalCodeDTO);

    street.setPostalCode(postalCode);

    return streetServiceMapper.toStreetDTO(streetRepository.save(street));
  }

  @Override
  public StreetDTO update(StreetDTO current, StreetDTO updated) {
    Street currentStreet = streetServiceMapper.toStreet(current);
    Street updatedStreet = streetServiceMapper.toStreet(updated);

    streetRepository.update(
        currentStreet.getId(),
        updatedStreet.getName(),
        updatedStreet.getHouseNumber(),
        updatedStreet.getPostalCode().getId());

    return streetServiceMapper.toStreetDTO(updatedStreet);
  }

  @Override
  public Optional<StreetDTO> find(Long id) {
    return this.streetRepository.findById(id).map(streetServiceMapper::toStreetDTO);
  }
}
