package com.base.ods.mapper;

import com.base.ods.domain.Role;
import com.base.ods.services.requests.RoleCreateRequestDTO;
import com.base.ods.services.requests.RoleUpdateRequestDTO;
import com.base.ods.services.responses.RoleResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleEntityToDTOMapper {
    RoleResponseDTO toDTO(Role role);
    Role responseDTOToEntity(RoleResponseDTO roleResponseDTO);
    Role toEntity(RoleCreateRequestDTO roleCreateRequestDTO);
    Role toEntity(RoleUpdateRequestDTO roleUpdateRequestDTO);

    List<RoleResponseDTO> toDTOList(List<Role> roleList);
}
