package com.base.ods.services.impl;

import com.base.ods.domain.Role;
import com.base.ods.exception.EntityAlreadyExistsException;
import com.base.ods.exception.EntityNotFoundException;
import com.base.ods.mapper.RoleEntityToDTOMapper;
import com.base.ods.repository.RoleRepository;
import com.base.ods.services.IRoleService;
import com.base.ods.services.requests.RoleCreateRequestDTO;
import com.base.ods.services.requests.RoleUpdateRequestDTO;
import com.base.ods.services.responses.RoleResponseDTO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
@Log4j2
public class RoleServiceImpl implements IRoleService {
    private RoleRepository roleRepository;
    private RoleEntityToDTOMapper mapper;

    @Override
    public List<RoleResponseDTO> getAllRoles() {
        List<Role> roleList = roleRepository.findAll();
        return mapper.toDTOList(roleList);
    }

    @Override
    public RoleResponseDTO getRoleById(Long id) {
        Role role = roleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Role Not Found"));
        return mapper.toDTO(role);
    }

    @Override
    public RoleResponseDTO createRole(RoleCreateRequestDTO roleCreateRequestDTO) {
        Role role = roleRepository.findByRoleName(roleCreateRequestDTO.getRoleName());
        if (role != null) {
            throw new EntityAlreadyExistsException("Entity with name " + roleCreateRequestDTO.getRoleName() + " already exists");
        }
        Role toSave = mapper.toEntity(roleCreateRequestDTO);
        Role result = roleRepository.save(toSave);
        return mapper.toDTO(result);
    }

    @Override
    public RoleResponseDTO updateRole(RoleUpdateRequestDTO roleUpdateRequestDTO) {
        Role role = roleRepository.findById(roleUpdateRequestDTO.getId()).orElseThrow(() -> new EntityNotFoundException("Role Not Found"));
        Role toUpdate = mapper.toEntity(roleUpdateRequestDTO);
        Role result = roleRepository.save(toUpdate);
        return mapper.toDTO(result);
    }

    @Override
    @Transactional
    public void deleteRolesByIds(List<Long> ids) {
        roleRepository.deleteByIdIn(ids);
    }
}
