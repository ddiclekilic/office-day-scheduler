package com.base.ods.requests;

import lombok.Data;

@Data
public class UserUpdateRequest {
    String firstName;
    String lastName;
    String email;
    String password;
    Long departmentId;
    Long zoneId;
    String transportChoice;
    Long roleId;
}
