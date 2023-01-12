package com.base.ods.mapper;

import com.base.ods.controllers.requests.RoleCreateRequest;
import com.base.ods.controllers.requests.RoleUpdateRequest;
import com.base.ods.controllers.responses.RoleResponse;
import com.base.ods.services.requests.RoleCreateRequestDTO;
import com.base.ods.services.requests.RoleUpdateRequestDTO;
import com.base.ods.services.responses.RoleResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleResponseToDTOMapper {
    RoleResponse toResponse(RoleResponseDTO roleResponseDTO);
    RoleCreateRequestDTO toDTO(RoleCreateRequest roleCreateRequest);
    RoleUpdateRequestDTO toDTO(RoleUpdateRequest roleUpdateRequest);
    List<RoleResponse> toResponseList(List<RoleResponseDTO> roleList);
}
