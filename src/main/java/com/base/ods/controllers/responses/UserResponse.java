package com.base.ods.controllers.responses;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    Long id;
    Long registrationNumber;
    String firstName;
    String lastName;
    String email;
    String roleName;
    Long roleId;
    String zoneName;
    String transportChoice;
    Long zoneId;
    Long departmentId;
    String departmentCode;
    String groupCode;
    Long departmentManagerId;
    String departmentManagerFirstName;
    String departmentManagerLastName;
    Long groupManagerId;
    String groupManagerFirstName;
    String groupManagerLastName;
    String status;
}
