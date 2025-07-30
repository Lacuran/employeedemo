package com.emplyee.employeedemo.service.employee;

import com.emplyee.employeedemo.dto.request.post.DepartmentDTO;
import com.emplyee.employeedemo.dto.resposce.DepartmentBriefDTO;
import com.emplyee.employeedemo.model.employee.Departments;
import com.emplyee.employeedemo.model.employee.Locations;
import com.emplyee.employeedemo.repository.employee.DepartmentRepository;
import com.emplyee.employeedemo.repository.employee.LocationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

  @Autowired
  private DepartmentRepository departmentRepository;
  @Autowired
  private LocationsRepository locationRepository;


  public List<DepartmentBriefDTO> getAllDepartments() {
    return departmentRepository.findAll()
        .stream()
        .map(dept -> new DepartmentBriefDTO(dept.getId(), dept.getName()))
        .collect(Collectors.toList());
  }

  public DepartmentDTO createDepartment(DepartmentDTO dto) {
    Locations location = locationRepository.findById(dto.getLocationId())
        .orElseThrow(() -> new RuntimeException("Location not found"));

    Departments department = new Departments();
    department.setName(dto.getName());
    department.setLocations(location);

    Departments saved = departmentRepository.save(department);
    dto.setId(saved.getId());
    return dto;

  }

  public DepartmentDTO updateDepartment(int id, DepartmentDTO dto)
}
