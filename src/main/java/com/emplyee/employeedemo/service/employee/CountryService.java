package com.emplyee.employeedemo.service.employee;

import com.emplyee.employeedemo.model.employee.Countries;
import com.emplyee.employeedemo.model.employee.Regions;
import com.emplyee.employeedemo.repository.employee.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

  @Autowired
  private CountryRepository countryRepository;

  public List<Countries> getAllCountries() {
    return countryRepository.findAll();
  }

  public Countries getCountryById(int id) {
    return countryRepository.findById(id).orElse(null);
  }

  public Countries createCountry(Countries countries) {
    return countryRepository.save(countries);
  }

  public Countries updateCountry(int id, String name, Regions regions) {
    Optional<Countries> optionalCountries = countryRepository.findById(id);


    return null;
  }

  public Boolean deleteCountry(int id) {
    if (countryRepository.findById(id).isPresent()) {
      countryRepository.deleteById(id);
      return true;
    }
    return false;
  }
}
