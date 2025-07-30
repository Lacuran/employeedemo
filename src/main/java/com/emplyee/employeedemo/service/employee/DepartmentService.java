package com.emplyee.employeedemo.service.employee;

import com.emplyee.employeedemo.dto.request.post.DepartmentDTO;
import com.emplyee.employeedemo.dto.resposce.DepartmentBriefDTO;
import com.emplyee.employeedemo.model.employee.Departments;
import com.emplyee.employeedemo.model.employee.Locations;
import com.emplyee.employeedemo.repository.employee.DepartmentRepository;
import com.emplyee.employeedemo.repository.employee.LocationsRepository;
import jakarta.persistence.EntityNotFoundException;
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

  public DepartmentDTO updateDepartment(int id, DepartmentDTO dto) {
    Departments dept = departmentRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Department not found"));

    Locations location = locationRepository.findById(dto.getLocationId())
        .orElseThrow(() -> new RuntimeException("Location not found"));

    Departments updated = departmentRepository.save(dept);
    return new DepartmentDTO(updated.getId(), updated.getName(), updated.getLocations().getId());

  }

  public void updateName(int id, String name) {
    Departments department = departmentRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Department not found"));

    department.setName(name);
    departmentRepository.save(department);
  }

  public void deleteDepartment(int id) {
    if (!departmentRepository.existsById(id)) {
      throw new EntityNotFoundException("Department not found");
    }
    departmentRepository.deleteById(id);
  }


}
