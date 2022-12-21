package com.base.ods.controllers.requests;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreateRequest {
    Long registrationNumber;
    String firstName;
    String lastName;
    String email;
    String password;
    String transportChoice;
    Long roleId;
    Long zoneId;
    Long departmentId;
}
