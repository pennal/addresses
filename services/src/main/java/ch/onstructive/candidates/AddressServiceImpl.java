/* Licensed under Apache-2.0 */
package ch.onstructive.candidates;

import java.util.List;
import java.util.Optional;

import javax.inject.Singleton;
import javax.transaction.Transactional;

/**
 * Implementation of {@link AddressService}.
 *
 * @author Silvio Wangler (silvio.wangler@onstructive.ch)
 */
@Singleton
public class AddressServiceImpl implements AddressService {

  private final PostalCodeRepository postalCodeRepository;
  private final AddressServiceMapper addressServiceMapper;

  public AddressServiceImpl(
      PostalCodeRepository postalCodeRepository, AddressServiceMapper addressServiceMapper) {
    this.postalCodeRepository = postalCodeRepository;
    this.addressServiceMapper = addressServiceMapper;
  }

  @Override
  public List<PostalCodeDTO> findAllPostalCodes() {
    List<PostalCode> allPostalCodes = postalCodeRepository.findAll();
    return addressServiceMapper.toPostalCodeDTOs(allPostalCodes);
  }

  @Override
  public Optional<PostalCodeDTO> find(Long id) {
    return postalCodeRepository.findById(id).map(addressServiceMapper::toPostalCodeDTO);
  }

  @Override
  @Transactional
  public PostalCodeDTO createPostalCode(PostalCodeDTO postalCode) {
    PostalCode postalCodeEntity = addressServiceMapper.toPostalCode(postalCode);
    return addressServiceMapper.toPostalCodeDTO(postalCodeRepository.save(postalCodeEntity));
  }
}
