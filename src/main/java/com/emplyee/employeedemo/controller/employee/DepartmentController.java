package com.emplyee.employeedemo.controller.employee;

import com.emplyee.employeedemo.dto.request.post.DepartmentDTO;
import com.emplyee.employeedemo.dto.resposce.DepartmentBriefDTO;
import com.emplyee.employeedemo.model.employee.Departments;
import com.emplyee.employeedemo.service.employee.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
@Tag(name = "Department API", description = "Operations related to departments")
public class DepartmentController {

  @Autowired
  private DepartmentService departmentService;


  @GetMapping
  @Operation(summary = "Get all departments")
  @ApiResponse(responseCode = "200", description = "List of all departments",
      content = @Content(mediaType = "application/json",
          schema = @Schema(implementation = DepartmentBriefDTO.class)))
  public ResponseEntity<List<DepartmentBriefDTO>> getAllDepartments() {
    List<DepartmentBriefDTO> departments = departmentService.getAllDepartments();
    return ResponseEntity.ok(departments);
  }

  @GetMapping("/{id}")
  @Operation(summary = "Get department by ID")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Department found",
          content = @Content(mediaType = "application/json",
              schema = @Schema(implementation = Departments.class))),
      @ApiResponse(responseCode = "404", description = "Department not found")
  })
  public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable int id) {
    DepartmentDTO dto = departmentService.getDepartmentById(id);
    return ResponseEntity.ok(dto);
  }

  @PostMapping
  @Operation(summary = "Create a new department")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "Department created",
          content = @Content(mediaType = "application/json",
              schema = @Schema(implementation = Departments.class))),
      @ApiResponse(responseCode = "400", description = "Invalid input")
  })
  public ResponseEntity<DepartmentDTO> createDepartment(@RequestBody DepartmentDTO dto) {
    DepartmentDTO created = departmentService.createDepartment(dto);
    return ResponseEntity.status(HttpStatus.CREATED).body(created);
  }


  @PutMapping("/{id}")
  @Operation(summary = "Update department by ID")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Department updated",
          content = @Content(mediaType = "application/json",
              schema = @Schema(implementation = Departments.class))),
      @ApiResponse(responseCode = "404", description = "Department not found")
  })
  public ResponseEntity<Void> updateDepartment(@PathVariable int id, @RequestBody DepartmentDTO dto) {
    departmentService.updateDepartment(id, dto);
    return ResponseEntity.noContent().build(); // 204
  }

  @PutMapping("/{id}/name")
  @Operation(summary = "Update department name by ID")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Department updated",
          content = @Content(mediaType = "application/json",
              schema = @Schema(implementation = DepartmentBriefDTO.class))),
      @ApiResponse(responseCode = "404", description = "Department not found")
  })
  public ResponseEntity<Void> updateDepartmentName(@PathVariable int id, @RequestBody DepartmentBriefDTO dto) {
    departmentService.updateName(id, dto.getName());
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/{id}")
  @Operation(summary = "Delete department by ID")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "204", description = "Department deleted"),
      @ApiResponse(responseCode = "404", description = "Department not found")
  })
  public ResponseEntity<Void> deleteDepartment(@PathVariable int id) {
    departmentService.deleteDepartment(id);
    return ResponseEntity.noContent().build();
  }

}
