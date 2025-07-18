package com.emplyee.employeedemo.controller.employee;

import com.emplyee.employeedemo.model.employee.Jobs;
import com.emplyee.employeedemo.model.employee.Regions;
import com.emplyee.employeedemo.service.employee.JobService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
@Tag(name = "Jobs API", description = "Operations related to jobs")
public class JobController {

  @Autowired
  private JobService jobService;

  @GetMapping
  @Operation(summary = "Get all jobs")
  @ApiResponse(responseCode = "200", description = "List of jobs",
      content = @Content(mediaType = "application/json",
          schema = @Schema(implementation = Jobs.class)))
  public ResponseEntity<List<Jobs>> getAllJobs() {
    List<Jobs> jobs = jobService.getAllJobs();
    return ResponseEntity.ok(jobs);
  }

  @GetMapping("/{id}")
  @Operation(summary = "Get job by id")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Job found",
          content = @Content(mediaType = "application/json",
              schema = @Schema(implementation = Jobs.class))),
      @ApiResponse(responseCode = "404", description = "Job not found")
  })
  public ResponseEntity<Jobs> getJobById(@PathVariable("id") int id) {
    Jobs jobs = jobService.getJobById(id);
    if (jobs != null) {
      return ResponseEntity.ok(jobs);
    }
    return ResponseEntity.notFound().build();
  }

  @GetMapping("/{title}")
  @Operation(summary = "Get job by title")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Job found",
          content = @Content(mediaType = "application/json",
              schema = @Schema(implementation = Jobs.class))),
      @ApiResponse(responseCode = "404", description = "Job not found")
  })
  public ResponseEntity<List<Jobs>> getJobByTitle(@PathVariable("title") String title) {
    List<Jobs> jobs = jobService.findJobByTitle(title);
    if (jobs != null) {
      return ResponseEntity.ok(jobs);
    }
    return ResponseEntity.notFound().build();
  }

  @PostMapping
  @Operation(summary = "Create a new region")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "Job created",
          content = @Content(mediaType = "application/json",
              schema = @Schema(implementation = Regions.class))),
      @ApiResponse(responseCode = "400", description = "Invalid input")
  })
  public ResponseEntity<Jobs> createJob(@RequestBody Jobs jobs) {
    Jobs createJob = jobService.createJob(jobs);
    return ResponseEntity.status(HttpStatus.CREATED).body(createJob);
  }

  @PutMapping("/{id}")
  @Operation(summary = "Update job by ID")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Job updated",
          content = @Content(mediaType = "application/json",
              schema = @Schema(implementation = Regions.class))),
      @ApiResponse(responseCode = "404", description = "Region not found")
  })
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
  @Operation(summary = "Delete job by ID")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "204", description = "Job deleted"),
      @ApiResponse(responseCode = "404", description = "Job not found")
  })
  public ResponseEntity<Void> deleteJob(@PathVariable("id") int id) {
    if (jobService.deleteJob(id)) {
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.notFound().build();
  }
}
