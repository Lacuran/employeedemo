package com.emplyee.employeedemo.model.dto.employee.create;

import io.swagger.v3.oas.models.annotations.OpenAPI30;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class JobCreateRequest {
  private String title;
  private BigDecimal min_salary;
  private BigDecimal max_salary;
}
