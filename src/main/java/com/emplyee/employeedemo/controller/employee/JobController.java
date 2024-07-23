package com.emplyee.employeedemo.controller.employee;

import com.emplyee.employeedemo.model.employee.Jobs;
import com.emplyee.employeedemo.service.employee.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

  @Autowired
  private JobService jobService;

  @GetMapping
  public ResponseEntity<List<Jobs>> getAllJobs() {
    List<Jobs> jobs = jobService.getAllJobs();
    return ResponseEntity.ok(jobs);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Jobs> getJobById(@PathVariable("id") int id) {
    Jobs jobs = jobService.getJobById(id);
    if (jobs != null) {
      return ResponseEntity.ok(jobs);
    }
    return ResponseEntity.notFound().build();
  }

  @GetMapping("/{title}")
  public ResponseEntity<List<Jobs>> getJobByTitle(@PathVariable("title") String title) {
    List<Jobs> jobs = jobService.findJobByTitle(title);
    if (jobs != null) {
      return ResponseEntity.ok(jobs);
    }
    return ResponseEntity.notFound().build();
  }

  @PostMapping
  public ResponseEntity<Jobs> createJob(@RequestBody Jobs jobs) {
    Jobs createJob = jobService.createJob(jobs);
    return ResponseEntity.status(HttpStatus.CREATED).body(createJob);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Jobs> updateJob(@PathVariable("id") int id, @RequestBody Jobs jobs) {
    Jobs updateJob = jobService.updateJob(id,
        jobs.getTitle(),
        jobs.getMin_salary(),
        jobs.getMax_salary());

    if (updateJob != null) {
      return ResponseEntity.ok(updateJob);
    }
    return ResponseEntity.notFound().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteJob(@PathVariable("id") int id) {
    if (jobService.deleteJob(id)) {
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.notFound().build();
  }
}
