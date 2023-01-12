package com.base.ods.services;

import com.base.ods.services.requests.DepartmentCreateRequestDTO;
import com.base.ods.services.requests.DepartmentUpdateRequestDTO;
import com.base.ods.services.responses.DepartmentResponseDTO;
import com.base.ods.util.IdWrapper;

import java.util.List;

public interface IDepartmentService {
    List<DepartmentResponseDTO> getAllDepartments();

    DepartmentResponseDTO getDepartmentById(Long id);

    DepartmentResponseDTO createDepartment(DepartmentCreateRequestDTO departmentCreateRequestDTO);

    DepartmentResponseDTO updateDepartment(DepartmentUpdateRequestDTO departmentUpdateRequestDTO);

    void deleteDepartmentsByIds(IdWrapper ids);
}
