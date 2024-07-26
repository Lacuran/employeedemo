package com.emplyee.employeedemo.mapper.employee;

import com.emplyee.employeedemo.model.dto.employee.create.RegionCreateRequest;
import com.emplyee.employeedemo.model.dto.employee.update.RegionUpdateRequest;
import com.emplyee.employeedemo.model.entity.employee.Regions;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RegionMapper {
  Regions createEntity(RegionCreateRequest dto);
  void updateRegion(RegionUpdateRequest dto, @MappingTarget Regions entity);
}
