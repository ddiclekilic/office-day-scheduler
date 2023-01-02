package com.base.ods.services.impl;

import com.base.ods.domain.Role;
import com.base.ods.exception.EntityAlreadyExistsException;
import com.base.ods.exception.EntityNotFoundException;
import com.base.ods.exception.MethodNotAllowedException;
import com.base.ods.mapper.RoleEntityToDTOMapper;
import com.base.ods.repository.RoleRepository;
import com.base.ods.services.IRoleService;
import com.base.ods.services.IUserService;
import com.base.ods.services.requests.RoleCreateRequestDTO;
import com.base.ods.services.requests.RoleUpdateRequestDTO;
import com.base.ods.services.responses.RoleResponseDTO;
import com.base.ods.util.constants.Messages;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class RoleServiceImpl implements IRoleService {
    private RoleRepository roleRepository;
    private RoleEntityToDTOMapper mapper;
    private IUserService userService;

    public RoleServiceImpl(RoleRepository roleRepository, RoleEntityToDTOMapper mapper, @Lazy IUserService userService) {
        this.roleRepository = roleRepository;
        this.mapper = mapper;
        this.userService = userService;
    }

    @Override
    public List<RoleResponseDTO> getAllRoles() {
        List<Role> roleList = roleRepository.findAll();
        return mapper.toDTOList(roleList);
    }

    @Override
    public RoleResponseDTO getRoleById(Long id) {
        Role role = roleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(Messages.ROLE_NOT_FOUND + id));
        return mapper.toDTO(role);
    }

    @Override
    public RoleResponseDTO createRole(RoleCreateRequestDTO roleCreateRequestDTO) {
        Optional<Role> role = roleRepository.findByRoleName(roleCreateRequestDTO.getRoleName());
        if (role.isPresent()) {
            throw new EntityAlreadyExistsException("Role with name " + roleCreateRequestDTO.getRoleName() + " already exists");
        }
        Role toSave = mapper.toEntity(roleCreateRequestDTO);
        Role result = roleRepository.save(toSave);
        return mapper.toDTO(result);
    }

    @Override
    public RoleResponseDTO updateRole(RoleUpdateRequestDTO roleUpdateRequestDTO) {
        Role role = roleRepository.findById(roleUpdateRequestDTO.getId()).orElseThrow(() -> new EntityNotFoundException(Messages.ROLE_NOT_FOUND + roleUpdateRequestDTO.getId()));
        Role toUpdate = mapper.toEntity(roleUpdateRequestDTO);
        Role result = roleRepository.save(toUpdate);
        return mapper.toDTO(result);
    }

    @Override
    @Transactional
    public void deleteRolesByIds(List<Long> ids) {
        for (Long id : ids) {
            if (!roleRepository.existsById(id)) {
                throw new EntityNotFoundException(Messages.ROLE_NOT_FOUND + id);
            }
            if (userService.roleExists(id)) {
                throw new MethodNotAllowedException("Role cannot be deleted");
            }
        }
        roleRepository.deleteByIdIn(ids);
    }
}
