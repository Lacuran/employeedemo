package com.emplyee.employeedemo.controller.employee;

import com.emplyee.employeedemo.service.employee.EmployeeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee")
@Tag(name = "Employee API", description = "Operations related to employee")
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;
}
