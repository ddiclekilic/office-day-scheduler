package com.base.ods.responses;

import com.base.ods.domain.Department;
import lombok.Data;

@Data
public class DepartmentResponse {
    Long id;
    String departmentCode;
    String departmentManagerName;
    String groupCode;
    String groupManagerName;

    public DepartmentResponse(Department entity) {
        this.id = entity.getId();
        this.departmentCode = entity.getDepartmentCode();
        this.departmentManagerName = entity.getDepartmentManager().getFirstName() + " " + entity.getDepartmentManager().getLastName();
        this.groupCode = entity.getGroupCode();
        this.groupManagerName = entity.getGroupManager().getFirstName() + " " + entity.getGroupManager().getLastName();
    }
}
