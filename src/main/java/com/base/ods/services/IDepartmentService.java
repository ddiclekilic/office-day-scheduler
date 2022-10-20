package com.base.ods.services;

import com.base.ods.entities.Department;

import java.util.List;

public interface IDepartmentService {
    List<Department> getAllDepartments();
    Department getDepartmentById(Long departmentId);
    void deleteDepartmentById(Long departmentId);
}
