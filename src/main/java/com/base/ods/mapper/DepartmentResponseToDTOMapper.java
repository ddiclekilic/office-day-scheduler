package com.base.ods.mapper;

import com.base.ods.controllers.requests.DepartmentCreateRequest;
import com.base.ods.controllers.requests.DepartmentUpdateRequest;
import com.base.ods.controllers.responses.DepartmentResponse;
import com.base.ods.services.requests.DepartmentCreateRequestDTO;
import com.base.ods.services.requests.DepartmentUpdateRequestDTO;
import com.base.ods.services.responses.DepartmentResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartmentResponseToDTOMapper {
    DepartmentResponse toResponse(DepartmentResponseDTO departmentResponseDTO);

    DepartmentCreateRequestDTO toDTO(DepartmentCreateRequest departmentCreateRequest);

    DepartmentUpdateRequestDTO toDTO(DepartmentUpdateRequest departmentUpdateRequest);

    List<DepartmentResponse> toResponseList(List<DepartmentResponseDTO> departments);
}
