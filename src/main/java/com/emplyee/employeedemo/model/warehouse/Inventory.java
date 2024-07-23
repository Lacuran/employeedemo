package com.emplyee.employeedemo.model.warehouse;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "inventory")
public class Inventory {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @ManyToOne
  @JoinColumn(name = "products_id", nullable = false)
  private Products products;

  @ManyToOne
  @JoinColumn(name = "warehouses_id", nullable = false)
  private Warehouses warehouses;

  @Column(name = "stock_quantity")
  private int stock_quantity;

  @Column(name = "last_updated")
  private String last_updated;

}
