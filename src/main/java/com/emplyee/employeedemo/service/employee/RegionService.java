package com.emplyee.employeedemo.service.employee;

import com.emplyee.employeedemo.mapper.employee.RegionMapper;
import com.emplyee.employeedemo.model.dto.employee.create.RegionCreateRequest;
import com.emplyee.employeedemo.model.dto.employee.update.RegionUpdateRequest;
import com.emplyee.employeedemo.model.entity.employee.Regions;
import com.emplyee.employeedemo.repository.employee.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegionService {

  @Autowired
  private RegionRepository regionRepository;

  @Autowired
  private RegionMapper regionMapper;

  public List<Regions> getAllRegions() {
    return regionRepository.findAll();
  }

  public Regions getRegionById(int id) {
    return regionRepository.findById(id).orElse(null);
  }

  public Regions createRegion(RegionCreateRequest request) {
    Regions regions = regionMapper.createEntity(request);
    return regionRepository.save(regions);
  }

  public Boolean deleteRegion(int id) {
    if (regionRepository.existsById(id)) {
      regionRepository.deleteById(id);
      return true;
    }
    return false;
  }

  public Regions updateRegionById(int id, RegionUpdateRequest request) {
    Optional<Regions> optionalRegions = regionRepository.findById(id);

    if (optionalRegions.isPresent()) {
      Regions regions = optionalRegions.get();
      regionMapper.updateRegion(request, regions);
      return regionRepository.save(regions);
    }
    return null;
  }
}
