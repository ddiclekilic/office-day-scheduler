package com.base.ods.mapper;

import com.base.ods.domain.Department;
import com.base.ods.services.requests.DepartmentCreateRequestDTO;
import com.base.ods.services.requests.DepartmentUpdateRequestDTO;
import com.base.ods.services.responses.DepartmentResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartmentEntityToDTOMapper {
    DepartmentResponseDTO toDTO(Department department);
    Department responseDTOToEntity(DepartmentResponseDTO departmentResponseDTO);
    Department toEntity(DepartmentCreateRequestDTO departmentCreateRequestDTO);
    Department toEntity(DepartmentUpdateRequestDTO departmentUpdateRequestDTO);

    List<DepartmentResponseDTO> toDTOList(List<Department> roleList);
}
