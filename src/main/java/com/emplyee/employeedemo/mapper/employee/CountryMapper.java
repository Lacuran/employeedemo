package com.emplyee.employeedemo.mapper.employee;

import com.emplyee.employeedemo.model.dto.employee.create.CountryCreateRequest;
import com.emplyee.employeedemo.model.dto.employee.update.CountryUpdateRequest;
import com.emplyee.employeedemo.model.entity.employee.Countries;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CountryMapper {

  Countries createEntity(CountryCreateRequest dto);
  void updateEntity(CountryUpdateRequest dto, @MappingTarget Countries entity);
}
