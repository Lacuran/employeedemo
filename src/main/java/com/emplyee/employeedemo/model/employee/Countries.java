package com.emplyee.employeedemo.model.employee;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "countries")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Countries {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "name", nullable = false)
  private String name;

  @ManyToOne
  @JoinColumn(name = "region_id", nullable = false)
  private Regions regions;
}
