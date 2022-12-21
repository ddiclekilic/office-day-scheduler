package com.base.ods.services;


import com.base.ods.services.requests.RoleCreateRequestDTO;
import com.base.ods.services.requests.RoleUpdateRequestDTO;
import com.base.ods.services.responses.RoleResponseDTO;

import java.util.List;

public interface IRoleService {
    List<RoleResponseDTO> getAllRoles();

    RoleResponseDTO getRoleById(Long id);

    RoleResponseDTO createRole(RoleCreateRequestDTO roleCreateRequestDTO);

    RoleResponseDTO updateRole(RoleUpdateRequestDTO roleUpdateRequestDTO);

    void deleteRolesByIds(List<Long> ids);
}
