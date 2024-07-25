package com.emplyee.employeedemo.repository.employee;

import com.emplyee.employeedemo.model.employee.Regions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Regions, Integer> {}
