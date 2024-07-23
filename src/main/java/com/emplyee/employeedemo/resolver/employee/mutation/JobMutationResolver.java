package com.emplyee.employeedemo.resolver.employee.mutation;

import com.emplyee.employeedemo.model.employee.Jobs;
import com.emplyee.employeedemo.service.employee.JobService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class JobMutationResolver implements GraphQLMutationResolver {

  @Autowired
  private JobService jobService;

  public Jobs createJob(String title, BigDecimal minSalary, BigDecimal maxSalary) {
    Jobs jobs = new Jobs();
    jobs.setTitle(title);
    jobs.setMin_salary(minSalary);
    jobs.setMax_salary(maxSalary);
    return jobService.createJob(jobs);
  }

  public Jobs updateJob(int id, String title, BigDecimal minSalary, BigDecimal maxSalary) {
    return jobService.updateJob(id, title, minSalary, maxSalary);
  }

  public Boolean deleteJob(int id) {
    return jobService.deleteJob(id);
  }
}
