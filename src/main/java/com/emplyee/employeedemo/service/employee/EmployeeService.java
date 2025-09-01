package com.emplyee.employeedemo.service.employee;

import com.emplyee.employeedemo.dto.request.post.EmployeeCreateDTO;
import com.emplyee.employeedemo.dto.request.put.EmployeeUpdateDTO;
import com.emplyee.employeedemo.dto.resposce.EmployeeDTO;
import com.emplyee.employeedemo.model.employee.Employee;
import com.emplyee.employeedemo.repository.employee.DepartmentRepository;
import com.emplyee.employeedemo.repository.employee.EmployeeRepository;
import com.emplyee.employeedemo.repository.employee.JobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;
  @Autowired
  private DepartmentRepository departmentRepository;
  @Autowired
  private  JobsRepository jobRepository;

  public EmployeeDTO createEmployee(EmployeeCreateDTO dto) {
    Employee employee = new Employee();

    employee.setFirstName(dto.getFirstName());
    employee.setMiddleName(dto.getMiddleName());
    employee.setLastName(dto.getLastName());
    employee.setEmail(dto.getEmail());
    employee.setPhoneNumber(dto.getPhoneNumber());
    employee.setHireDate(dto.getHireDate());
    employee.setSalary(dto.getSalary());
    employee.setCommission_pct(dto.getCommissionPct());

    employee.setDepartments(departmentRepository.findById(dto.getDepartmentId())
        .orElseThrow(() -> new RuntimeException("Department not found")));

    employee.setJobs(jobRepository.findById(dto.getJobId())
        .orElseThrow(() -> new RuntimeException("Job not found")));

    if (dto.getManagerId() != null) {
      employee.setManager(employeeRepository.findById(dto.getManagerId())
          .orElseThrow(() -> new RuntimeException("Manager not found")));
    }

    Employee saved = employeeRepository.save(employee);

    return mapToDto(saved);
  }

  public EmployeeDTO getEmployeeById(int id) {
    Employee employee = employeeRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Employee not found"));
    return mapToDto(employee);
  }

  public List<EmployeeDTO> getAllEmployees() {
    return employeeRepository.findAll().stream()
        .map(this::mapToDto)
        .collect(Collectors.toList());
  }

  public EmployeeDTO updateEmployee(EmployeeUpdateDTO dto) {
    Employee employee = employeeRepository.findById(dto.getId())
        .orElseThrow(() -> new RuntimeException("Employee not found"));

    if (dto.getFirstName() != null) employee.setFirstName(dto.getFirstName());
    if (dto.getMiddleName() != null) employee.setMiddleName(dto.getMiddleName());
    if (dto.getLastName() != null) employee.setLastName(dto.getLastName());
    if (dto.getEmail() != null) employee.setEmail(dto.getEmail());
    if (dto.getPhoneNumber() != null) employee.setPhoneNumber(dto.getPhoneNumber());
    if (dto.getHireDate() != null) employee.setHireDate(dto.getHireDate());
    if (dto.getSalary() != null) employee.setSalary(dto.getSalary());
    if (dto.getCommissionPct() != null) employee.setCommission_pct(dto.getCommissionPct());

    if (dto.getDepartmentId() != null) {
      employee.setDepartments(departmentRepository.findById(dto.getDepartmentId())
          .orElseThrow(() -> new RuntimeException("Department not found")));
    }

    if (dto.getJobId() != null) {
      employee.setJobs(jobRepository.findById(dto.getJobId())
          .orElseThrow(() -> new RuntimeException("Job not found")));
    }

    if (dto.getManagerId() != null) {
      employee.setManager(employeeRepository.findById(dto.getManagerId())
          .orElseThrow(() -> new RuntimeException("Manager not found")));
    }

    Employee updated = employeeRepository.save(employee);
    return mapToDto(updated);
  }

  public void deleteEmployee(int id) {
    if (!employeeRepository.existsById(id)) {
      throw new RuntimeException("Employee not found");
    }
    employeeRepository.deleteById(id);
  }

  public List<EmployeeDTO> findByLastName(String lastName) {
    List<Employee> employees = employeeRepository.findByLastName(lastName);
    return employees.stream()
        .map(this::mapToDto)
        .collect(Collectors.toList());
  }

  public EmployeeDTO findByEmail(String email) {
    Employee employee = employeeRepository.findByEmail(email)
        .orElseThrow(() -> new RuntimeException("Employee not found"));
    return mapToDto(employee);
  }

  public List<EmployeeDTO> findByHireDateBetween(LocalDate startDate, LocalDate endDate) {
    List<Employee> employees = employeeRepository.findByHireDateBetween(startDate, endDate);
    return employees.stream()
        .map(this::mapToDto)
        .collect(Collectors.toList());
  }

  public boolean existsByEmail(String email) {
    return employeeRepository.existsByEmail(email);
  }

  private EmployeeDTO mapToDto(Employee saved) {
    EmployeeDTO result = new EmployeeDTO();
    result.setId(saved.getId());
    result.setFirstName(saved.getFirstName());
    result.setMiddleName(saved.getMiddleName());
    result.setLastName(saved.getLastName());
    result.setEmail(saved.getEmail());
    result.setPhoneNumber(saved.getPhoneNumber());
    result.setHireDate(saved.getHireDate());
    result.setSalary(saved.getSalary());
    result.setCommissionPct(saved.getCommission_pct());
    result.setDepartmentId(saved.getDepartments().getId());
    result.setJobId(saved.getJobs().getId());
    result.setManagerId(saved.getManager() != null ? saved.getManager().getId() : null);

    return result;
  }

}