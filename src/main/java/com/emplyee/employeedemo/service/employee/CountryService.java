package com.emplyee.employeedemo.service.employee;

import com.emplyee.employeedemo.model.employee.Countries;
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

  public Countries updateCountry(int id, String name) {
    Optional<Countries> optionalCountries = countryRepository.findById(id);

    if (optionalCountries.isPresent()) {
      Countries countries = optionalCountries.get();

      if (name != null && !name.trim().isEmpty()) {
        countries.setName(name);
      }
      return countryRepository.save(countries);
    }

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
