/* Licensed under Apache-2.0 */
package ch.onstructive.candidates;

import java.util.Objects;

public class StreetDTO {
  private Long id;
  private Short version;
  private String name;
  private Short houseNumber;
  private PostalCodeDTO postalCodeDTO;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Short getVersion() {
    return version;
  }

  public void setVersion(Short version) {
    this.version = version;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Short getHouseNumber() {
    return houseNumber;
  }

  public void setHouseNumber(Short houseNumber) {
    this.houseNumber = houseNumber;
  }

  public PostalCodeDTO getPostalCodeDTO() {
    return postalCodeDTO;
  }

  public void setPostalCodeDTO(PostalCodeDTO postalCodeDTO) {
    this.postalCodeDTO = postalCodeDTO;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    StreetDTO streetDTO = (StreetDTO) o;
    return Objects.equals(id, streetDTO.id)
        && Objects.equals(version, streetDTO.version)
        && Objects.equals(name, streetDTO.name)
        && Objects.equals(houseNumber, streetDTO.houseNumber)
        && Objects.equals(postalCodeDTO, streetDTO.postalCodeDTO);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, version, name, houseNumber, postalCodeDTO);
  }
}
