package com.emplyee.employeedemo.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "DTO for updating a region")
public class RegionUpdateDTO {

  @Schema(description = "Region name", example = "Małopolskie")
  @NotBlank(message = "Region name is required")
  private String name;

  @Schema(description = "ID of the country", example = "1")
  @Min(value = 1, message = "Valid countryId is required")
  private int countryId;

}
