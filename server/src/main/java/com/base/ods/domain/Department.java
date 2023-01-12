package com.base.ods.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false, unique = true)
    String departmentCode;
    @Column(nullable = false, unique = true)
    String groupCode;
    @Column(nullable = false)
    Long departmentManagerId;
    @Column(nullable = false)
    Long groupManagerId;
}
