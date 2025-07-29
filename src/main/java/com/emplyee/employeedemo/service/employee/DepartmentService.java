package com.emplyee.employeedemo.service.employee;

import com.emplyee.employeedemo.model.employee.Departments;
import com.emplyee.employeedemo.repository.employee.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DepartmentService {

  @Autowired
  private DepartmentRepository departmentRepository;

  public List<Departments> getAllDepartments() {
    return departmentRepository.findAll();
  }
}
