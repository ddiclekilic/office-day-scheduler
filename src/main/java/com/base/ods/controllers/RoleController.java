package com.base.ods.controllers;

import com.base.ods.controllers.requests.RoleCreateRequest;
import com.base.ods.controllers.requests.RoleUpdateRequest;
import com.base.ods.controllers.responses.RoleResponse;
import com.base.ods.mapper.RoleResponseToDTOMapper;
import com.base.ods.services.IRoleService;
import com.base.ods.services.requests.RoleCreateRequestDTO;
import com.base.ods.services.requests.RoleUpdateRequestDTO;
import com.base.ods.services.responses.RoleResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
@AllArgsConstructor
public class RoleController {
    private IRoleService roleService;
    private RoleResponseToDTOMapper mapper;

    @GetMapping
    public ResponseEntity<List<RoleResponse>> getAllRoles() {
        List<RoleResponseDTO> responseDTO = roleService.getAllRoles();
        List<RoleResponse> result = mapper.toResponseList(responseDTO);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleResponse> getRoleById(@PathVariable Long id) {
        RoleResponseDTO responseDTO = roleService.getRoleById(id);
        RoleResponse result = mapper.toResponse(responseDTO);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<RoleResponse> createRole(@RequestBody RoleCreateRequest roleCreateRequest) {
        RoleCreateRequestDTO requestDTO = mapper.toDTO(roleCreateRequest);
        RoleResponseDTO responseDTO = roleService.createRole(requestDTO);
        RoleResponse result = mapper.toResponse(responseDTO);
        return ResponseEntity.ok(result);
    }

    @PutMapping
    public ResponseEntity<RoleResponse> updateRoleById(@RequestBody RoleUpdateRequest roleUpdateRequest) {
        RoleUpdateRequestDTO requestDTO = mapper.toDTO(roleUpdateRequest);
        RoleResponseDTO responseDTO = roleService.updateRole(requestDTO);
        RoleResponse result = mapper.toResponse(responseDTO);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{ids}")
    public void deleteRolesByIds(@PathVariable List<Long> ids) {
        roleService.deleteRolesByIds(ids);
    }
}
