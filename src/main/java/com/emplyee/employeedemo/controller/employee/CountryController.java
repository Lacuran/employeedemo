package com.emplyee.employeedemo.controller.employee;

import com.emplyee.employeedemo.service.employee.CountryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/country")
@Tag(name = "Country API", description = "Operations related to countries")
public class CountryController {

  @Autowired
  private CountryService countryService;
}
