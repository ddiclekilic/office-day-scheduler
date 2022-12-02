package com.base.ods.services;

import com.base.ods.domain.Role;

import java.util.List;

public interface IRoleService {
    List<Role> getAllRoles();
    Role getRoleById(Long roleId);
    Role createRole(Role role);
    Role updateRoleById(Long roleId, Role role);
    void deleteRolesByIds(List<Long> ids);
}
