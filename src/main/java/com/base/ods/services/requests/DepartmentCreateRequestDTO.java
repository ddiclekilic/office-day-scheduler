package com.base.ods.services.requests;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DepartmentCreateRequestDTO {
    String departmentCode;
    String groupCode;
    Long departmentManagerId;
    Long groupManagerId;
}
