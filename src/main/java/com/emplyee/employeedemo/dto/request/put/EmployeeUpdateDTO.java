package com.emplyee.employeedemo.dto.request.put;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeUpdateDTO {

  private String firstName;
  private String middleName;
  private String lastName;
  private String email;
  private String phoneNumber;
  private LocalDate hireDate;
  private BigDecimal salary;
  private BigDecimal commissionPct;
  private Integer departmentId;
  private Integer jobId;
  private Integer managerId;

}
