package com.emplyee.employeedemo.service.employee;

import com.emplyee.employeedemo.dto.request.post.CountryCreateDTO;
import com.emplyee.employeedemo.dto.request.put.CountryUpdateDTO;
import com.emplyee.employeedemo.model.employee.Countries;
import com.emplyee.employeedemo.repository.employee.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

  public Countries createCountry(CountryCreateDTO dto) {
    Countries country = new Countries();
    country.setName(dto.getName());
    country.setRegions(new ArrayList<>());
    return countryRepository.save(country);
  }

  public Countries updateCountry(int id, CountryUpdateDTO dto) {
    Countries country = countryRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Country not found"));

    String countryName = dto.getName();
    if (countryName != null && !countryName.trim().isEmpty()) {
      country.setName(countryName);
    }
    return countryRepository.save(country);
  }

  public Boolean deleteCountry(int id) {
    if (countryRepository.findById(id).isPresent()) {
      countryRepository.deleteById(id);
      return true;
    }
    return false;
  }
}
