package com.emplyee.employeedemo.model.employee;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;


@Entity
@Table(name = "jobs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Jobs {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private int id;

  @Column(name = "title", nullable = false)
  private String title;

  @Column(name = "min_salary")
  private BigDecimal min_salary;

  @Column(name = "max_salary")
  private BigDecimal max_salary;

}
