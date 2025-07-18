package com.emplyee.employeedemo.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CountryCreateDTO {

  @NotBlank(message = "Country name is required")
  private String name;

}
