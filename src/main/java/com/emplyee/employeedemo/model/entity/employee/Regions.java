package com.emplyee.employeedemo.model.entity.employee;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "regions")
public class Regions {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "name", nullable = false)
  private String name;
}
