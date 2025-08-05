package com.emplyee.employeedemo.dto.resposce;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeDTO {
  private int id;
  private String firstName;
  private String middleName;
  private String lastName;
  private String email;
  private String phoneNumber;
  private LocalDate hireDate;
  private BigDecimal salary;
  private BigDecimal commissionPct;

  private int departmentId;
  private int jobId;
  private Integer managerId;

}
