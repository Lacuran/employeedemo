package com.emplyee.employeedemo.resolver.employee.mutation;

import com.emplyee.employeedemo.model.employee.Regions;
import com.emplyee.employeedemo.service.employee.RegionService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegionsMutationResolver implements GraphQLMutationResolver {

  @Autowired
  private RegionService regionService;


  public Regions createRegion(String name) {
    Regions regions = new Regions();
    regions.setName(name);
    return regionService.createRegion(regions);
  }

  public Regions updateRegions(int id, String name) {
    return regionService.updateRegionById(id, name);
  }

  public Boolean deleteRegion(int id) {
    return regionService.deleteRegion(id);
  }

}
