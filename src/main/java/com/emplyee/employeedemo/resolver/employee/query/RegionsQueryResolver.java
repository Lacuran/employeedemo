package com.emplyee.employeedemo.resolver.employee.query;

import com.emplyee.employeedemo.model.employee.Regions;
import com.emplyee.employeedemo.service.employee.RegionService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RegionsQueryResolver implements GraphQLQueryResolver {

  @Autowired
  private RegionService regionService;

  public List<Regions> getAllRegions() {
    return regionService.getAllRegions();
  }
  public Regions getRegionById(int id) {
    return regionService.getRegionById(id);
  }
}
