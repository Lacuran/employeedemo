package com.emplyee.employeedemo.controller.employee;

import com.emplyee.employeedemo.model.dto.employee.create.RegionCreateRequest;
import com.emplyee.employeedemo.model.dto.employee.update.RegionUpdateRequest;
import com.emplyee.employeedemo.model.entity.employee.Regions;
import com.emplyee.employeedemo.service.employee.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/regions")
public class RegionController {

  @Autowired
  private RegionService regionService;

  @GetMapping
  public ResponseEntity<List<Regions>> getAllRegions() {
    List<Regions> regions = regionService.getAllRegions();
    return ResponseEntity.ok(regions);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Regions> getRegionById(@PathVariable("id") int id) {
    Regions regions = regionService.getRegionById(id);
    if (regions != null) {
      return ResponseEntity.ok(regions);
    }
    return ResponseEntity.notFound().build();
  }

  @PostMapping
  public ResponseEntity<Regions> createRegion(@RequestBody RegionCreateRequest request) {
    Regions createRegion = regionService.createRegion(request);
    return ResponseEntity.status(HttpStatus.CREATED).body(createRegion);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Regions> updateRegion(@PathVariable("id") int id, @RequestBody RegionUpdateRequest request) {
    Regions updateRegion = regionService.updateRegionById(id, request);
    if (updateRegion != null) {
      return ResponseEntity.ok(updateRegion);
    }
    return ResponseEntity.notFound().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteRegion(@PathVariable("id") int id) {
    if (regionService.deleteRegion(id)) {
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.notFound().build();
  }
}
