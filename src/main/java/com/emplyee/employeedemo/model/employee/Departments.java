package com.emplyee.employeedemo.model.employee;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "departments")
public class Departments {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Column(name = "name", nullable = false)
  private String name;

  @ManyToOne
  @JoinColumn(name = "location_id", nullable = false)
  private Locations locations;

  @OneToMany(mappedBy = "departments")
  private List<Employees> employees;

}
