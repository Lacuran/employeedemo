package com.emplyee.employeedemo.controller.employee;

import com.emplyee.employeedemo.dto.request.post.LocationCreateDTO;
import com.emplyee.employeedemo.dto.request.put.LocationUpdateDTO;
import com.emplyee.employeedemo.dto.resposce.LocationDTO;
import com.emplyee.employeedemo.service.employee.LocationsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
public class LocationsController {

  @Autowired
  private LocationsService locationsService;

  @GetMapping
  public List<LocationDTO> getAll() {
    return locationsService.getAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<LocationDTO> getById(@PathVariable int id) {
    return ResponseEntity.ok(locationsService.getById(id));
  }

  @PostMapping
  public ResponseEntity<LocationDTO> create(@RequestBody @Valid LocationCreateDTO dto) {
    return ResponseEntity.status(HttpStatus.CREATED).body(locationsService.createLocation(dto));
  }

  @PutMapping("/{id}")
  public ResponseEntity<LocationDTO> update(@PathVariable int id, @RequestBody @Valid LocationUpdateDTO dto) {
    return ResponseEntity.ok(locationsService.updateLocation(id, dto));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable int id) {
    locationsService.deleteLocation(id);
    return ResponseEntity.noContent().build();
  }

}
