package com.emplyee.employeedemo.service.employee;

import com.emplyee.employeedemo.model.employee.Jobs;
import com.emplyee.employeedemo.repository.employee.JobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class JobService {

  @Autowired
  private JobsRepository jobsRepository;

  public List<Jobs> getAllJobs() {
    return jobsRepository.findAll();
  }

  public Jobs getJobById(int id) {
    return jobsRepository.findById(id).orElse(null);
  }

  public Jobs createJob(Jobs jobs) {
    return jobsRepository.save(jobs);
  }

  public Boolean deleteJob(int id) {
    if (jobsRepository.existsById(id)) {
      jobsRepository.deleteById(id);
      return true;
    }
    return false;
  }

  public List<Jobs> findJobByTitle(String title) {
    return jobsRepository.findByTitle(title);
  }

  public Jobs updateJob(int id, String title, BigDecimal minSalary, BigDecimal maxSalary) {
    Optional<Jobs> optionalJobs = jobsRepository.findById(id);

    if (optionalJobs.isPresent()) {
      Jobs jobs = optionalJobs.get();

      if (title != null && !title.trim().isEmpty()) {
        jobs.setTitle(title);
      }
      if (minSalary != null) {
        jobs.setMin_salary(minSalary);
      }
      if (maxSalary != null) {
        jobs.setMax_salary(maxSalary);
      }
      return jobsRepository.save(jobs);
    }
    return null;
  }
}
