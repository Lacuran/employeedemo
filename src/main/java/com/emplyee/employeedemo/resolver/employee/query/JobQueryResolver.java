package com.emplyee.employeedemo.resolver.employee.query;

import com.emplyee.employeedemo.model.employee.Jobs;
import com.emplyee.employeedemo.service.employee.JobService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JobQueryResolver implements GraphQLQueryResolver {

  @Autowired
  private JobService jobService;

  public List<Jobs> getAllJobs() {
    return jobService.getAllJobs();
  }

  public Jobs getJobById(int id) {
    return jobService.getJobById(id);
  }

  public List<Jobs> findJobByTitle(String title) {
    return jobService.findJobByTitle(title);
  }
}
