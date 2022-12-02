package com.base.ods.services.impl;

import com.base.ods.domain.Role;
import com.base.ods.repository.RoleRepository;
import com.base.ods.services.IRoleService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Log4j2
public class RoleServiceImpl implements IRoleService {
    private RoleRepository roleRepository;

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleById(Long roleId) {
        Role role = roleRepository.findById(roleId).orElse(null);
        if (role != null)
            return role;
        else {
            log.warn("Role not found by given {} id number.", roleId);
            return null;
        }
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
            roleRepository.save(toUpdate);
            log.info("Role with id {} updated.", toUpdate.getId());
            return toUpdate;
        } else {
            log.warn("There is no role information in the database with {} id number.", roleId);
            return null;
        }
    }

    @Override
    @Transactional
    public void deleteRolesByIds(List<Long> ids) {
        roleRepository.deleteByIdIn(ids);
    }
}
