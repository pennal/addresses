/* Licensed under Apache-2.0 */
package ch.onstructive.candidates;

/**
 * Not found exception type.
 *
 * @author Silvio Wangler (silvio.wangler@onstructive.ch)
 */
public class NotFoundException extends RuntimeException {
  private final Long id;
  private final String type;

  public NotFoundException(Long id, String type) {
    this.id = id;
    this.type = type;
  }

  public Long getId() {
    return id;
  }

  public String getType() {
    return type;
  }
}
