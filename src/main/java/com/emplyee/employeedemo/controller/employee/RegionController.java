package com.emplyee.employeedemo.controller.employee;

import com.emplyee.employeedemo.dto.request.RegionCreateDTO;
import com.emplyee.employeedemo.dto.request.RegionUpdateDTO;
import com.emplyee.employeedemo.dto.resposce.RegionDTO;
import com.emplyee.employeedemo.model.employee.Regions;
import com.emplyee.employeedemo.service.employee.RegionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/regions")
@Tag(name = "Regions API", description = "Operations related to regions")
public class RegionController {

  @Autowired
  private RegionService regionService;

  @GetMapping
  @Operation(summary = "Get all region")
  @ApiResponse(responseCode = "200", description = "List of regions",
      content = @Content(mediaType = "application/json",
          schema = @Schema(implementation = Regions.class)))
  public ResponseEntity<List<Regions>> getAllRegions() {
    List<Regions> regions = regionService.getAllRegions();
    return ResponseEntity.ok(regions);
  }

  @GetMapping("/{id}")
  @Operation(summary = "Get region by ID")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Region found",
          content = @Content(mediaType = "application/json",
              schema = @Schema(implementation = Regions.class))),
      @ApiResponse(responseCode = "404", description = "Region not found")
  })
  public ResponseEntity<Regions> getRegionById(@PathVariable("id") int id) {
    Regions regions = regionService.getRegionById(id);
    if (regions != null) {
      return ResponseEntity.ok(regions);
    }
    return ResponseEntity.notFound().build();
  }

  @PostMapping
  @Operation(summary = "Create a new region")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "Region created",
          content = @Content(mediaType = "application/json",
              schema = @Schema(implementation = Regions.class))),
      @ApiResponse(responseCode = "400", description = "Invalid input")
  })
  public ResponseEntity<RegionDTO> createRegion(@RequestBody @Valid RegionCreateDTO dto) {
    Regions createRegion = regionService.createRegion(dto);
    return ResponseEntity.status(HttpStatus.CREATED).body(new RegionDTO(createRegion));
  }

  @PutMapping("/{id}")
  @Operation(summary = "Update region by ID")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Region updated",
          content = @Content(mediaType = "application/json",
              schema = @Schema(implementation = Regions.class))),
      @ApiResponse(responseCode = "404", description = "Region not found")
  })
  public ResponseEntity<RegionDTO> updateRegion(@PathVariable int id, @RequestBody @Valid RegionUpdateDTO dto) {
    Regions updateRegion = regionService.updateRegion(id, dto);

    if (updateRegion != null) {
      return ResponseEntity.ok(new RegionDTO(updateRegion));
    }
    return ResponseEntity.notFound().build();
  }

  @DeleteMapping("/{id}")
  @Operation(summary = "Delete region by ID")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "204", description = "Region deleted"),
      @ApiResponse(responseCode = "404", description = "Region not found")
  })
  public ResponseEntity<Void> deleteRegion(@PathVariable("id") int id) {
    if (regionService.deleteRegion(id)) {
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.notFound().build();
  }
}
