package com.emplyee.employeedemo.repository.employee;

import com.emplyee.employeedemo.model.employee.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobsRepository extends JpaRepository<Jobs, Integer> {
  List<Jobs> findByTitle(String title);
}
