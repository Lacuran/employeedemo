package com.emplyee.employeedemo.controller.employee;

import com.emplyee.employeedemo.service.employee.DepartmentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/department")
@Tag(name = "Department API", description = "Operations related to departments")
public class DepartmentController {

  @Autowired
  private DepartmentService departmentService;

}
