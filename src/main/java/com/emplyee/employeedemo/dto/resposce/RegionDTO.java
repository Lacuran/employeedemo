package com.emplyee.employeedemo.dto.resposce;

import com.emplyee.employeedemo.model.employee.Regions;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegionDTO {
  private int id;
  private String name;

  public RegionDTO(Regions region) {
    this.id = region.getId();
    this.name = region.getName();
  }
}
