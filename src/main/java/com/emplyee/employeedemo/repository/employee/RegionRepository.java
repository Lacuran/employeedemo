package com.emplyee.employeedemo.repository.employee;

import com.emplyee.employeedemo.model.employee.Regions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegionRepository extends JpaRepository<Regions, Integer> {}
