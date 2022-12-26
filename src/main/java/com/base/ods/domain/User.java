package com.base.ods.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false, unique = true)
    @NotNull(message = "Registration number is mandatory")
    Long registrationNumber;
    @Column(nullable = false)
    @NotBlank(message = "First name is mandatory")
    String firstName;
    @Column(nullable = false)
    @NotBlank(message = "Last name is mandatory")
    String lastName;
    @Column(nullable = false, unique = true)
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Invalid email")
    String email;
    @Column(nullable = false)
    @NotBlank(message = "Password is mandatory")
    String password;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id") //nullable=false
    Department department;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "zone_id", nullable = false)
    Zone zone;
    @Column(nullable = false)
    @NotBlank(message = "Transport choice is mandatory")
    String transportChoice;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", nullable = false)
    Role role;
}
