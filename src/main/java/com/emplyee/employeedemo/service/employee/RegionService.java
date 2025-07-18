package com.emplyee.employeedemo.service.employee;

import com.emplyee.employeedemo.dto.request.RegionCreateDTO;
import com.emplyee.employeedemo.dto.request.RegionUpdateDTO;
import com.emplyee.employeedemo.model.employee.Countries;
import com.emplyee.employeedemo.model.employee.Regions;
import com.emplyee.employeedemo.repository.employee.CountryRepository;
import com.emplyee.employeedemo.repository.employee.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {

  @Autowired
  private RegionRepository regionRepository;

  @Autowired
  private CountryRepository countryRepository;


  public List<Regions> getAllRegions() {
    return regionRepository.findAll();
  }

  public Regions getRegionById(int id) {
    return regionRepository.findById(id).orElse(null);
  }

  public Regions createRegion(RegionCreateDTO dto) {
    Countries country = countryRepository.findById(dto.getCountryId())
        .orElseThrow(() -> new RuntimeException("Country not found"));

    Regions region = new Regions();
    region.setName(dto.getName());
    region.setCountry(country);

    return regionRepository.save(region);
  }


  public Boolean deleteRegion(int id) {
    if (regionRepository.existsById(id)) {
      regionRepository.deleteById(id);
      return true;
    }
    return false;
  }

  public Regions updateRegion(int id, RegionUpdateDTO dto) {
    Regions region = regionRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Region not found"));

    Countries country = countryRepository.findById(dto.getCountryId())
        .orElseThrow(() -> new RuntimeException("Country not found"));

    region.setName(dto.getName());
    region.setCountry(country);

    return regionRepository.save(region);

  }
}
