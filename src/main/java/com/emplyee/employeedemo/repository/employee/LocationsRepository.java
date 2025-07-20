package com.emplyee.employeedemo.repository.employee;

import com.emplyee.employeedemo.model.employee.Locations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationsRepository extends JpaRepository<Locations, Integer> {
}
