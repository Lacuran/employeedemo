package com.emplyee.employeedemo.model.employee;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "locations")
public class Locations {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "street_address")
  private String street_address;

  @Column(name = "postal_code")
  private String postal_code;

  @Column(name = "city", nullable = false)
  private String city;

  @Column(name = "state_province")
  private String state_province;

  @ManyToOne
  @JoinColumn(name = "country_id", nullable = false)
  private Countries countries;

}
