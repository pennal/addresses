/* Licensed under Apache-2.0 */
package ch.onstructive.candidates;

import java.util.Objects;

import javax.persistence.*;

@Entity
public class Street {
  @Id @GeneratedValue private Long id;

  @Version private Short version;

  @Column(nullable = false)
  private Short houseNumber;

  @Column(nullable = false, length = 100)
  private String name;

  @ManyToOne private PostalCode postalCode;

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

  public Short getHouseNumber() {
    return houseNumber;
  }

  public void setHouseNumber(Short houseNumber) {
    this.houseNumber = houseNumber;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public PostalCode getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(PostalCode postalCode) {
    this.postalCode = postalCode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Street street = (Street) o;
    return Objects.equals(id, street.id)
        && Objects.equals(version, street.version)
        && Objects.equals(houseNumber, street.houseNumber)
        && Objects.equals(name, street.name)
        && Objects.equals(postalCode, street.postalCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, version, houseNumber, name, postalCode);
  }
}
