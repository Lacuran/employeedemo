package com.emplyee.employeedemo.controller.employee;

import com.emplyee.employeedemo.dto.request.post.EmployeeCreateDTO;
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
}
