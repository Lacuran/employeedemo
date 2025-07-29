package com.emplyee.employeedemo.controller.employee;

import com.emplyee.employeedemo.dto.request.post.LocationCreateDTO;
import com.emplyee.employeedemo.dto.request.put.LocationUpdateDTO;
import com.emplyee.employeedemo.dto.resposce.LocationDTO;
import com.emplyee.employeedemo.model.employee.Locations;
import com.emplyee.employeedemo.service.employee.LocationsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
  @Operation(summary = "Get all locations")
  @ApiResponse(responseCode = "200", description = "List of all locations",
      content = @Content(mediaType = "application/json",
          schema = @Schema(implementation = Locations.class)))
  public List<LocationDTO> getAll() {
    return locationsService.getAll();
  }

  @GetMapping("/{id}")
  @Operation(summary = "Get location information")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "List of all locations",
          content = @Content(mediaType = "application/json",
              schema = @Schema(implementation = Locations.class))),
      @ApiResponse(responseCode = "404", description = "Location not found")
  })
  public ResponseEntity<LocationDTO> getById(@PathVariable int id) {
    return ResponseEntity.ok(locationsService.getById(id));
  }

  @PostMapping
  @Operation(summary = "Create new location")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "Location created",
          content = @Content(mediaType = "application/json",
              schema = @Schema(implementation = Locations.class))),
      @ApiResponse(responseCode = "400", description = "Invalid input")
  })
  public ResponseEntity<LocationDTO> create(@RequestBody @Valid LocationCreateDTO dto) {
    return ResponseEntity.status(HttpStatus.CREATED).body(locationsService.createLocation(dto));
  }

  @PutMapping("/{id}")
  @Operation(summary = "Update Location by ID")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Location updated",
          content = @Content(mediaType = "application/json",
              schema = @Schema(implementation = Locations.class))),
      @ApiResponse(responseCode = "404", description = "Country not found")
  })
  public ResponseEntity<LocationDTO> update(@PathVariable int id, @RequestBody @Valid LocationUpdateDTO dto) {
    return ResponseEntity.ok(locationsService.updateLocation(id, dto));
  }

  @DeleteMapping("/{id}")
  @Operation(summary = "Delete Location by ID")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "204", description = "Location deleted"),
      @ApiResponse(responseCode = "404", description = "Location not found")
  })
  public ResponseEntity<Void> delete(@PathVariable int id) {
    locationsService.deleteLocation(id);
    return ResponseEntity.noContent().build();
  }

}
