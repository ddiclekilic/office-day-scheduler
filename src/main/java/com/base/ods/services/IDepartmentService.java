package com.base.ods.services;

import com.base.ods.domain.Department;
import com.base.ods.requests.DepartmentRequest;
import com.base.ods.responses.DepartmentResponse;

import java.util.List;

public interface IDepartmentService {
    List<DepartmentResponse> getAllDepartments();
    Department getDepartmentById(Long departmentId);
    Department createDepartment(DepartmentRequest departmentCreateRequest);
    Department updateDepartmentById(Long departmentId, DepartmentRequest departmentUpdateRequest);
    void deleteDepartmentsByIds(List<Long> ids);
}
