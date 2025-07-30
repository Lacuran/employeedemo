package com.emplyee.employeedemo.dto.resposce;

import com.emplyee.employeedemo.model.employee.Locations;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class LocationDTO {
  private int id;
  private String street_address;
  private String postal_code;
  private String city;
  private String state_province;
  private CountryListDTO country;
  private List<DepartmentBriefDTO> departments;

  public LocationDTO(Locations location) {
    this.id = location.getId();
    this.street_address = location.getStreet_address();
    this.postal_code = location.getPostal_code();
    this.city = location.getCity();
    this.state_province = location.getState_province();
    if (location.getCountries() != null) {
      this.country = new CountryListDTO(location.getCountries());
    }
    if (location.getDepartments() != null) {
      this.departments = location.getDepartments()
          .stream()
          .map(dept -> new DepartmentBriefDTO(dept.getId(), dept.getName()))
          .collect(Collectors.toList());
    }

  }

}
