package com.emplyee.employeedemo.repository.employee;

import com.emplyee.employeedemo.model.employee.Countries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Countries, Integer> {
}
