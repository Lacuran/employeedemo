package com.emplyee.employeedemo.model.employee;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "departments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Departments {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private int id;

  @Column(name = "name", nullable = false)
  private String name;

  @ManyToOne
  @JoinColumn(name = "location_id", nullable = false)
  private Locations locations;

}
