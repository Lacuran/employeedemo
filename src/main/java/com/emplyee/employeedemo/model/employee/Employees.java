package com.emplyee.employeedemo.model.employee;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "employees")
public class Employees {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
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
  private String hire_date;

  @ManyToOne
  @JoinColumn(name = "job_id", nullable = false)
  private Jobs jobs;

  @ManyToOne
  @JoinColumn(name = "department_id", nullable = false)
  private Departments departments;

  @ManyToOne
  @JoinColumn(name = "manager_id")
  private Employees manager;

  @Column(name = "salary")
  private BigDecimal salary;

  @Column(name = "commission_pct")
  private BigDecimal commission_pct;

  @OneToMany(mappedBy = "manager")
  private List<Employees> subordinates;
}
