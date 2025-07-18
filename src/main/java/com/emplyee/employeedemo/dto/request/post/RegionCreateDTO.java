package com.emplyee.employeedemo.dto.request.post;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegionCreateDTO {

  @NotBlank(message = "Region name is required")
  private String name;

  @Min(value = 1, message = "Valid countryId is required")
  private int countryId;

}
