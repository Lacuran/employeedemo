package com.emplyee.employeedemo.dto.resposce;

import com.emplyee.employeedemo.model.employee.Locations;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationDTO {
  private int id;
  private String street_address;
  private String postal_code;
  private String city;
  private String state_province;
  private CountryListDTO country;

  public LocationDTO(Locations location) {
    this.id = location.getId();
    this.street_address = location.getStreet_address();
    this.postal_code = location.getPostal_code();
    this.city = location.getCity();
    this.state_province = location.getState_province();
    if (location.getCountries() != null) {
      this.country = new CountryListDTO(location.getCountries());
    }
  }

}
