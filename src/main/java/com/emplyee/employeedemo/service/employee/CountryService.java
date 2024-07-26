package com.emplyee.employeedemo.service.employee;

import com.emplyee.employeedemo.mapper.employee.CountryMapper;
import com.emplyee.employeedemo.model.dto.employee.create.CountryCreateRequest;
import com.emplyee.employeedemo.model.dto.employee.update.CountryUpdateRequest;
import com.emplyee.employeedemo.model.entity.employee.Countries;
import com.emplyee.employeedemo.repository.employee.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

  @Autowired
  private CountryRepository countryRepository;

  @Autowired
  private CountryMapper countryMapper;

  public List<Countries> getAllCountries() {
    return countryRepository.findAll();
  }

  public Countries getCountryById(int id) {
    return countryRepository.findById(id).orElse(null);
  }

  public Countries createCountry(CountryCreateRequest request) {
    Countries countries = countryMapper.createEntity(request);
    return countryRepository.save(countries);
  }

  public Boolean deleteCountry(int id) {
    if (countryRepository.findById(id).isPresent()) {
      countryRepository.deleteById(id);
      return true;
    }
    return false;
  }

  public Countries updateCountry(int id, CountryUpdateRequest request) {
    Optional<Countries> optionalCountries = countryRepository.findById(id);

    if (optionalCountries.isPresent()) {
      Countries countries = optionalCountries.get();
      countryMapper.updateEntity(request, countries);
      return countryRepository.save(countries);
    }
    return null;
  }

}
