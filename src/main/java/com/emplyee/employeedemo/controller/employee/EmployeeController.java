package com.emplyee.employeedemo.controller.employee;

import com.emplyee.employeedemo.dto.request.post.EmployeeCreateDTO;
import com.emplyee.employeedemo.dto.request.put.EmployeeUpdateDTO;
import com.emplyee.employeedemo.dto.resposce.EmployeeDTO;
import com.emplyee.employeedemo.model.employee.Employee;
import com.emplyee.employeedemo.service.employee.EmployeeService;
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

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
@Tag(name = "Employee API", description = "Operations related to employee")
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;


  @GetMapping
  @Operation(summary = "Get all employees")
  @ApiResponse(responseCode = "200", description = "List of all employees",
      content = @Content(mediaType = "application/json",
          schema = @Schema(implementation = EmployeeDTO.class)))
  public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
    List<EmployeeDTO> employees = employeeService.getAllEmployees();
    return ResponseEntity.ok(employees);
  }

  @GetMapping("/{id}")
  @Operation(summary = "Get employee by ID")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Employee found",
          content = @Content(mediaType = "application/json",
              schema = @Schema(implementation = Employee.class))),
      @ApiResponse(responseCode = "404", description = "Employee not found")
  })
  public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable int id) {
    EmployeeDTO dto = employeeService.getEmployeeById(id);
    return ResponseEntity.ok(dto);
  }

  @GetMapping("/by-last-name")
  @Operation(summary = "Get employee by Last Name")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Employee found",
          content = @Content(mediaType = "application/json",
              schema = @Schema(implementation = Employee.class))),
      @ApiResponse(responseCode = "404", description = "Employee not found")
  })
  public ResponseEntity<List<EmployeeDTO>> getEmployeeByLastName(@PathVariable String lastName) {
    List<EmployeeDTO> dto = employeeService.findByLastName(lastName);
    return ResponseEntity.ok(dto);
  }

  @DeleteMapping("/{id}")
  @Operation(summary = "Delete employee by ID")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "204", description = "Employee deleted"),
      @ApiResponse(responseCode = "404", description = "Employee not found")
  })
  public ResponseEntity<Void> deleteEmployee(@PathVariable int id) {
    employeeService.deleteEmployee(id);
    return ResponseEntity.noContent().build();
  }

  @PostMapping
  @Operation(summary = "Create a new employee")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "Employee created",
          content = @Content(mediaType = "application/json",
              schema = @Schema(implementation = Employee.class))),
      @ApiResponse(responseCode = "400", description = "Invalid input")
  })
  public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeCreateDTO dto) {
    EmployeeDTO created = employeeService.createEmployee(dto);
    return ResponseEntity.status(HttpStatus.CREATED).body(created);
  }

  @PutMapping("/{id}")
  @Operation(summary = "Update employee by Id")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Employee updated",
          content = @Content(mediaType = "application/json",
              schema = @Schema(implementation = Employee.class))),
      @ApiResponse(responseCode = "404", description = "Employee not found")
  })
  public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable int id, @RequestBody EmployeeUpdateDTO dto) {
    EmployeeDTO update = employeeService.updateEmployee(id, dto);
    return ResponseEntity.status(HttpStatus.OK).body(update);
  }

  @GetMapping("/by-email")
  @Operation(summary = "Get employee by Email")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Employee found",
          content = @Content(mediaType = "application/json",
              schema = @Schema(implementation = Employee.class))),
      @ApiResponse(responseCode = "404", description = "Employee not found")
  })
  public ResponseEntity<EmployeeDTO> getEmployeeByEmail(@PathVariable String email) {
    EmployeeDTO dto = employeeService.findByEmail(email);
    return ResponseEntity.ok(dto);
  }

  @GetMapping("/hire-date")
  @Operation(summary = "Get employee by Email")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Employee found",
          content = @Content(mediaType = "application/json",
              schema = @Schema(implementation = Employee.class))),
      @ApiResponse(responseCode = "404", description = "Employee not found")
  })
  public ResponseEntity<List<EmployeeDTO>> findByHireDateBetween(@RequestParam LocalDate start, @RequestParam LocalDate end) {
    List<EmployeeDTO> dto = employeeService.findByHireDateBetween(start, end);
    return ResponseEntity.ok(dto);
  }
}
