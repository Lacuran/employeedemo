package com.emplyee.employeedemo.dto.request.post;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeCreateDTO {

  @NotBlank
  private String firstName;

  private String middleName;

  @NotBlank
  private String lastName;

  @Email
  private String email;

  private String phoneNumber;

  @PastOrPresent
  private LocalDate hireDate;

  @DecimalMin("0.00")
  private BigDecimal salary;

  @DecimalMin("0.00")
  private BigDecimal commissionPct;

  private int departmentId;
  private int jobId;
  private Integer managerId;
}
