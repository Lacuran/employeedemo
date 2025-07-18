package com.emplyee.employeedemo.dto.resposce;

import com.emplyee.employeedemo.model.employee.Countries;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CountryListDTO {
  private int id;
  private String name;

  public CountryListDTO(Countries country) {
    this.id = country.getId();
    this.name = country.getName();
  }

}
