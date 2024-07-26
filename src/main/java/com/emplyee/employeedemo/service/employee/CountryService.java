package com.emplyee.employeedemo.service.employee;

import com.emplyee.employeedemo.repository.employee.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

  @Autowired
  private CountryRepository countryRepository;


}
