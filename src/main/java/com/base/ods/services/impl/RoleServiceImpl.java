package com.base.ods.services.impl;

import com.base.ods.domain.Role;
import com.base.ods.repository.RoleRepository;
import com.base.ods.services.IRoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements IRoleService {
    private RoleRepository roleRepository;

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleById(Long roleId) {
        return roleRepository.findById(roleId).orElse(null);
    }

    @Override
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role updateRoleById(Long roleId, Role role) {
        Optional<Role> roleUpdate = roleRepository.findById(roleId);
        if (roleUpdate.isPresent()) {
            Role toUpdate = roleUpdate.get();
            toUpdate.setRoleName(role.getRoleName());
            return roleRepository.save(toUpdate);
        } else
            return null;
    }

    @Override
    public void deleteRoleById(Long roleId) {
        roleRepository.deleteById(roleId);
    }
}
