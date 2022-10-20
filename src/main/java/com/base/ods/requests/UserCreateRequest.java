package com.base.ods.requests;

import lombok.Data;

@Data
public class UserCreateRequest {
    Long registrationNumber;
    String firstName;
    String lastName;
    String email;
    String password;
    Long departmentId;
    Long zoneId;
    String transportChoice;
    Long roleId;
}
