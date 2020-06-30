/* Licensed under Apache-2.0 */
package ch.onstructive.candidates;

import java.util.Objects;

/**
 * DTO for postal code.
 *
 * @author Silvio Wangler (silvio.wangler@onstructive.ch)
 */
public class PostalCodeDTO {

  private Long id;
  private Short version;
  private Short postalCode;
  private String displayName;

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

  public Short getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(Short postalCode) {
    this.postalCode = postalCode;
  }

  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    PostalCodeDTO that = (PostalCodeDTO) o;
    return Objects.equals(id, that.id)
        && Objects.equals(version, that.version)
        && Objects.equals(postalCode, that.postalCode)
        && Objects.equals(displayName, that.displayName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, version, postalCode, displayName);
  }
}
