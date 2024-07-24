package com.emplyee.employeedemo.controller.employee;

import com.emplyee.employeedemo.service.employee.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/regions")
public class RegionController {

  @Autowired
  private RegionService regionService;


}
