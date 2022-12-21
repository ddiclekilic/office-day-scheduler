package com.base.ods.services.requests;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdateRequestDTO {
    Long id;
    String firstName;
    String lastName;
    String email;
    String password;
    String transportChoice;
    Long roleId;
    Long zoneId;
    Long departmentId;
}
