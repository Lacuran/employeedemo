package com.emplyee.employeedemo.dto.request.post;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DepartmentDTO {
  private int id;
  private String name;
  private int locationId;
}
