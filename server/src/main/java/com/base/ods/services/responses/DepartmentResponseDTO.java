package com.base.ods.services.responses;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DepartmentResponseDTO {
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
