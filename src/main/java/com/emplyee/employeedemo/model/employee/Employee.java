package com.emplyee.employeedemo.model.employee;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private int id;

  @Column(name = "first_name", nullable = false)
  private String first_name;

  @Column(name = "middle_name")
  private String middle_name;

  @Column(name = "last_name", nullable = false)
  private String last_name;

  @Column(name = "email", nullable = false, unique = true)
  private String email;

  @Column(name = "phone_number")
  private String phone_number;

  @Column(name = "hire_date")
  private LocalDate hireDate;

  @ManyToOne
  @JoinColumn(name = "job_id", nullable = false)
  private Jobs jobs;

  @ManyToOne
  @JoinColumn(name = "department_id", nullable = false)
  private Departments departments;

  @ManyToOne
  @JoinColumn(name = "manager_id")
  @JsonBackReference
  private Employee manager;

  @Column(name = "salary")
  private BigDecimal salary;

  @Column(name = "commission_pct")
  private BigDecimal commission_pct;
}
