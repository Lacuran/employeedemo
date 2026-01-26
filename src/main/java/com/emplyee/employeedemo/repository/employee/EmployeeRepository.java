package com.emplyee.employeedemo.repository.employee;

import com.emplyee.employeedemo.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

  List<Employee> findByLastName(String lastName);

  List<Employee> findByHireDateBetween(LocalDate startDate, LocalDate endDate);

  Optional<Employee> findByEmail(String email);

}
