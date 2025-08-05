package com.emplyee.employeedemo.repository.employee;

import com.emplyee.employeedemo.model.employee.Departments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Departments, Integer> {
}
