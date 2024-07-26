package com.emplyee.employeedemo.model.dto.employee.update;

import lombok.Data;

@Data
public class CountryUpdateRequest {
  private String name;
  private int region_id;
}
