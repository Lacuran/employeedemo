package com.emplyee.employeedemo.model.warehouse;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "warehouses")
public class Warehouses {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "location", nullable = false)
  private String location;

  @OneToMany(mappedBy = "warehouses")
  private List<Inventory> inventoryList;

}
