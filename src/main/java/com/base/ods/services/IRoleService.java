package com.base.ods.services;

import com.base.ods.entities.Role;

import java.util.List;

public interface IRoleService {
    List<Role> getAllRoles();
    Role getRoleById(Long roleId);
    Role createRole(Role role);
    Role updateRoleById(Long roleId, Role role);
    void deleteRoleById(Long roleId);
}
