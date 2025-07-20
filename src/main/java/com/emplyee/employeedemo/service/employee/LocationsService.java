package com.emplyee.employeedemo.service.employee;

import com.emplyee.employeedemo.dto.request.post.LocationCreateDTO;
import com.emplyee.employeedemo.dto.request.put.LocationUpdateDTO;
import com.emplyee.employeedemo.dto.resposce.LocationDTO;
import com.emplyee.employeedemo.model.employee.Countries;
import com.emplyee.employeedemo.model.employee.Locations;
import com.emplyee.employeedemo.repository.employee.CountryRepository;
import com.emplyee.employeedemo.repository.employee.LocationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationsService {

  @Autowired
  private LocationsRepository locationsRepository;
  @Autowired
  private CountryRepository countryRepository;

  public List<LocationDTO> getAll() {
    return locationsRepository.findAll().stream()
        .map(LocationDTO::new).toList();
  }

  public LocationDTO getById(int id) {
    return locationsRepository.findById(id)
        .map(LocationDTO::new)
        .orElseThrow(() -> new RuntimeException("Location not found"));
  }

  public LocationDTO createLocation(LocationCreateDTO dto) {
    Countries country = countryRepository.findById(dto.getCountryId())
        .orElseThrow(() -> new RuntimeException("Country not found"));

    Locations location = new Locations();
    location.setStreet_address(dto.getStreet_address());
    location.setPostal_code(dto.getPostal_code());
    location.setCity(dto.getCity());
    location.setState_province(dto.getState_province());
    location.setCountries(country);

    return new LocationDTO(locationsRepository.save(location));
  }

  public LocationDTO updateLocation(int id, LocationUpdateDTO dto) {
    Locations location = locationsRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Location not found"));

    Countries country = countryRepository.findById(dto.getCountryId())
        .orElseThrow(() -> new RuntimeException("Country not found"));

    location.setStreet_address(dto.getStreet_address());
    location.setPostal_code(dto.getPostal_code());
    location.setCity(dto.getCity());
    location.setState_province(dto.getState_province());
    location.setCountries(country);

    return new LocationDTO(locationsRepository.save(location));
  }

  public Boolean deleteLocation(int id) {
    if (locationsRepository.existsById(id)){
      locationsRepository.deleteById(id);
      return true;
    }
    return false;
  }

}
