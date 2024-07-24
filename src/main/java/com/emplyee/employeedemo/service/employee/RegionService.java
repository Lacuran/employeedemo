package com.emplyee.employeedemo.service.employee;

import com.emplyee.employeedemo.model.employee.Regions;
import com.emplyee.employeedemo.repository.employee.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegionService {

  @Autowired
  private RegionRepository regionRepository;

  public List<Regions> getAllRegions() {
    return regionRepository.findAll();
  }

  public Regions findRegionById(int id) {
    return regionRepository.findById(id).orElse(null);
  }

  public Regions createRegion(Regions regions) {
    return regionRepository.save(regions);
  }

  public Boolean deleteRegion(int id) {
    if (regionRepository.existsById(id)) {
      regionRepository.deleteById(id);
      return true;
    }
    return false;
  }

  public Regions updateRegionById(int id, String name) {
    Optional<Regions> optionalRegions = regionRepository.findById(id);

    if (optionalRegions.isPresent()) {
      Regions regions = optionalRegions.get();

      if (name != null && !name.trim().isEmpty()) {
        regions.setName(name);
      }
      return regionRepository.save(regions);
    }
    return null;
  }
}
