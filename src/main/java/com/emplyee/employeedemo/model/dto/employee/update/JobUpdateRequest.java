package com.emplyee.employeedemo.model.dto.employee.update;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class JobUpdateRequest {
  private String title;
  private BigDecimal min_salary;
  private BigDecimal max_salary;
}
