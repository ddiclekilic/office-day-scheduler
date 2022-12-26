package com.base.ods.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false, unique = true)
    @NotBlank(message = "Department code is mandatory")
    String departmentCode;
    @Column(nullable = false, unique = true)
    @NotBlank(message = "Grup code is mandatory")
    String groupCode;
    @Column(nullable = false)
    @NotNull(message = "Department Manager ID is mandatory")
    Long departmentManagerId;
    @Column(nullable = false)
    @NotNull(message = "Group Manager ID is mandatory")
    Long groupManagerId;
}
