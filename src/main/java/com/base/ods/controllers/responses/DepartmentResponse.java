package com.base.ods.controllers.responses;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DepartmentResponse {
    Long id;
    String departmentCode;
    String groupCode;
    Long departmentManagerId;
    Long groupManagerId;
    String departmentManagerFirstName;
    String departmentManagerLastName;
    String groupManagerFirstName;
    String groupManagerLastName;
}
