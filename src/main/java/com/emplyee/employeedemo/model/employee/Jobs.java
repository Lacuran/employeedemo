package com.emplyee.employeedemo.model.employee;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;


@Data
@Entity
@Table(name = "jobs")
public class Jobs {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "title", nullable = false)
  private String title;

  @Column(name = "min_salary")
  private BigDecimal min_salary;

  @Column(name = "max_salary")
  private BigDecimal max_salary;

  @OneToMany(mappedBy = "jobs")
  private List<Employees> employees;
}
