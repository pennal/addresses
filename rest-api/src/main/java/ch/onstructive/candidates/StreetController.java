/* Licensed under Apache-2.0 */
package ch.onstructive.candidates;

import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;

@Controller("/api/v1/streets")
public class StreetController {

  private final StreetControllerMapper streetControllerMapper;
  private final StreetService streetService;

  private final PostalCodeController postalCodeController;
  private final AddressService addressService;

  public StreetController(
      StreetControllerMapper streetControllerMapper,
      StreetService streetService,
      PostalCodeController postalCodeController,
      AddressService addressService) {
    this.streetControllerMapper = streetControllerMapper;
    this.streetService = streetService;
    this.addressService = addressService;
    this.postalCodeController = postalCodeController;
  }

  @Get
  public List<StreetGetModel> findAllStreets() {
    return this.streetControllerMapper.toStreetGetModels(this.streetService.findAllStreets());
  }

  @Get("/{id}")
  public StreetGetModel findStreetById(Long id) {
    return streetService
        .find(id)
        .map(streetControllerMapper::toStreetGetModel)
        .orElseThrow(() -> new NotFoundException(id, "street"));
  }

  @Post
  public HttpStatus create(@Valid @Body StreetPostModel model) {
    // Verify if the id passed in of the postal code is valid
    Long postalCodeId = model.getPostalCodeId();

    PostalCodeDTO postalCodeDTO =
        this.addressService
            .find(postalCodeId)
            .orElseThrow(() -> new NotFoundException(postalCodeId, "postalCode"));

    this.streetService.createStreet(this.streetControllerMapper.toStreetDTO(model), postalCodeDTO);

    return HttpStatus.CREATED;
  }

  @Put
  public StreetGetModel updateStreet(@Valid @Body StreetPutModel model) {
    return streetService
        .find(model.getId())
        .map(
            fetched -> {
              PostalCodeDTO postalCode =
                  this.addressService
                      .find(model.getPostalCodeId())
                      .orElseThrow(
                          () -> new NotFoundException(model.getPostalCodeId(), "postalCode"));

              // Assign it to the postalCodeDTO
              StreetDTO updatedStreetDTO = this.streetControllerMapper.toStreetDTO(model);
              updatedStreetDTO.setPostalCodeDTO(postalCode);

              StreetDTO streetDTO = this.streetService.update(fetched, updatedStreetDTO);

              return streetControllerMapper.toStreetGetModel(streetDTO);
            })
        .orElseThrow(() -> new NotFoundException(model.getId(), "street"));
  }

  static class StreetGetModel {

    private Long id;
    private String name;
    private Short houseNumber;
    private PostalCodeDTO postalCode;

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
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

    public PostalCodeDTO getPostalCode() {
      return postalCode;
    }

    public void setPostalCode(PostalCodeDTO postalCode) {
      this.postalCode = postalCode;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      StreetGetModel that = (StreetGetModel) o;
      return Objects.equals(id, that.id)
          && Objects.equals(name, that.name)
          && Objects.equals(houseNumber, that.houseNumber)
          && Objects.equals(postalCode, that.postalCode);
    }

    @Override
    public int hashCode() {
      return Objects.hash(id, name, houseNumber, postalCode);
    }
  }

  @Introspected
  static class StreetPostModel {
    @NotBlank private String name;

    @Min(0)
    private Short houseNumber;

    @NotNull private Long postalCodeId;

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

    public Long getPostalCodeId() {
      return postalCodeId;
    }

    public void setPostalCodeId(Long postalCodeId) {
      this.postalCodeId = postalCodeId;
    }
  }

  @Introspected
  static class StreetPutModel {
    @NotNull private Long id;

    @NotBlank private String name;

    @Min(0)
    private Short houseNumber;

    @NotNull private Long postalCodeId;

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
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

    public Long getPostalCodeId() {
      return postalCodeId;
    }

    public void setPostalCodeId(Long postalCodeId) {
      this.postalCodeId = postalCodeId;
    }
  }
}
