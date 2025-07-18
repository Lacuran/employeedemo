package com.emplyee.employeedemo.dto.resposce;

import com.emplyee.employeedemo.model.employee.Countries;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CountryResponseDTO {
  private int id;
  private String name;
  private List<RegionDTO> regions;


  public CountryResponseDTO(Countries country) {
    this.id = country.getId();
    this.name = country.getName();
    this.regions = country.getRegions().stream()
        .map(RegionDTO::new)
        .toList();

  }

}
