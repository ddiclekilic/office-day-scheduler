package com.base.ods.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false, unique = true)
    @NotBlank(message = "Name is mandatory")
    String roleName;
}
