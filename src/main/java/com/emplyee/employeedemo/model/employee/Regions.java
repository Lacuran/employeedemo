package com.emplyee.employeedemo.model.employee;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Entity
@Table(name = "regions")
public class Regions {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "name", nullable = false)
  private String name;

  @OneToMany(mappedBy = "regions")
  private List<Countries> countries;
}
