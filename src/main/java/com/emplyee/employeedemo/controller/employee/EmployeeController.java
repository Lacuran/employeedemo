package com.emplyee.employeedemo.controller.employee;

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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
  public ResponseEntity<List<EmployeeDTO>> getAllDepartments() {
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
  public ResponseEntity<EmployeeDTO> getDepartmentById(@PathVariable int id) {
    EmployeeDTO dto = employeeService.getEmployeeById(id);
    return ResponseEntity.ok(dto);
  }
}
