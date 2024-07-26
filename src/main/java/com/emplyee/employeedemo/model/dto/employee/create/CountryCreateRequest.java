package com.emplyee.employeedemo.model.dto.employee.create;

import io.swagger.v3.oas.models.annotations.OpenAPI30;
import lombok.Data;

@Data
public class CountryCreateRequest {
  private String name;
  private int region_id;
}
