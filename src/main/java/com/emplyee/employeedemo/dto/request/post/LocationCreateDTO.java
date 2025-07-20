package com.emplyee.employeedemo.dto.request.post;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationCreateDTO {

  @NotBlank(message = "Street address is required")
  private String street_address;
  @NotBlank(message = "Postal code is required")
  private String postal_code;
  @NotBlank(message = "City is required")
  private String city;
  private String state_province;
  @NotNull(message = "Country cannot be empty")
  private Integer countryId;

}
