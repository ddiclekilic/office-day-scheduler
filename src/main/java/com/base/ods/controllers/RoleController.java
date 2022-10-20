package com.base.ods.controllers;

import com.base.ods.entities.Role;
import com.base.ods.services.IRoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {
    private IRoleService roleService;

    public RoleController(IRoleService roleService) {
        this.roleService = roleService;
    }
    @GetMapping
    public List<Role> getAllRoles(){
        return roleService.getAllRoles();
    }
    @GetMapping("/{roleId}")
    public Role getRoleById(@PathVariable Long roleId){
        return roleService.getRoleById(roleId);
    }
    @PostMapping
    public Role createRole(@RequestBody Role role){
        return roleService.createRole(role);
    }
    @PutMapping("/{roleId}")
    Role updateRoleById(@PathVariable Long roleId, @RequestBody Role role){
        return roleService.updateRoleById(roleId, role);
    }
    @DeleteMapping("/{roleId}")
    public void deleteRoleById(@PathVariable Long roleId){
        roleService.deleteRoleById(roleId);
    }
}
