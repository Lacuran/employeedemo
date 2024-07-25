package com.emplyee.employeedemo.repository.employee;

import com.emplyee.employeedemo.model.employee.Countries;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Countries, Integer> {
}
