package com.base.ods.controllers.requests;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreateRequest {
    @NotNull(message = "Registration number is required")
    Long registrationNumber;
    @NotBlank(message = "First name is required")
    String firstName;
    @NotBlank(message = "Last name is required")
    String lastName;
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email")
    String email;
    @NotBlank(message = "Password is required")
    String password;
    @NotBlank(message = "Transport choice is required")
    String transportChoice;
    @NotNull(message = "Role Id is required")
    Long roleId;
    @NotNull(message = "Zone Id is required")
    Long zoneId;
    @NotNull(message = "Department Id is required")
    Long departmentId;
}
