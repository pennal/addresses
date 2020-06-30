/* Licensed under Apache-2.0 */
package ch.onstructive.candidates;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Represent a Swiss postal code such as (8000 Zurich or 6925 Gentilino).
 *
 * @author Silvio Wangler (silvio.wangler@onstructive.ch)
 */
@Entity
public class PostalCode {

  @Id @GeneratedValue private Long id;

  @Version private Short version;

  /** the numeric postal code value such as 8000 or 6926. */
  @Min(1000)
  @Max(9999)
  @Column(nullable = false)
  private Short postalCode;

  /** Display name for the {@link PostalCode#postalCode}. E.g. Zurich or Gentilino. */
  @Column(nullable = false, length = 100)
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
    PostalCode that = (PostalCode) o;
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
