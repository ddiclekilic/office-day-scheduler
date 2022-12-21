package com.base.ods.controllers.requests;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DepartmentCreateRequest {
    String departmentCode;
    String groupCode;
    Long departmentManagerId;
    Long groupManagerId;
}
