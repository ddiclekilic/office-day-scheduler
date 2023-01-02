package com.base.ods.controllers.requests;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DepartmentUpdateRequest {
    @NotNull(message = "Id is required")
    Long id;
    @NotBlank(message = "Department code is required")
    String departmentCode;
    @NotBlank(message = "Grup code is required")
    String groupCode;
    @NotNull(message = "Department Manager ID is required")
    Long departmentManagerId;
    @NotNull(message = "Group Manager ID is required")
    Long groupManagerId;
}
