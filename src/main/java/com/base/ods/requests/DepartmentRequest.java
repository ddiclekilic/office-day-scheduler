package com.base.ods.requests;

import lombok.Data;

@Data
public class DepartmentRequest {
    String departmentCode;
    String groupCode;
    Long departmentManagerId;
    Long groupManagerId;
}
