package com.emplyee.employeedemo.dto.request.put;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "DTO for updating a country")
public class CountryUpdateDTO {

  @Schema(description = "New name of the country", example = "Polska")
  @NotBlank(message = "Country name is required")
  private String name;

}
