package com.emplyee.employeedemo.mapper.employee;

import com.emplyee.employeedemo.model.dto.employee.create.JobCreateRequest;
import com.emplyee.employeedemo.model.dto.employee.update.JobUpdateRequest;
import com.emplyee.employeedemo.model.entity.employee.Jobs;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface JobMapper {

  Jobs createEntity(JobCreateRequest dto);
  void updateEntity(JobUpdateRequest dto, @MappingTarget Jobs entity);
}
