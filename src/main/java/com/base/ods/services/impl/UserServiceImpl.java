package com.base.ods.services.impl;

import com.base.ods.domain.*;
import com.base.ods.exception.EntityNotFoundException;
import com.base.ods.mapper.DepartmentEntityToDTOMapper;
import com.base.ods.mapper.RoleEntityToDTOMapper;
import com.base.ods.mapper.UserEntityToDTOMapper;
import com.base.ods.mapper.ZoneEntityToDTOMapper;
import com.base.ods.repository.UserRepository;
import com.base.ods.services.IRoleService;
import com.base.ods.services.IUserService;
import com.base.ods.services.requests.UserCreateRequestDTO;
import com.base.ods.services.requests.UserUpdateRequestDTO;
import com.base.ods.services.responses.DepartmentResponseDTO;
import com.base.ods.services.responses.RoleResponseDTO;
import com.base.ods.services.responses.UserResponseDTO;
import com.base.ods.services.IDepartmentService;
import com.base.ods.services.IZoneService;
import com.base.ods.services.responses.ZoneResponseDTO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
@AllArgsConstructor
@Log4j2
public class UserServiceImpl implements IUserService {
    private UserRepository userRepository;
    private IDepartmentService departmentService;
    private IZoneService zoneService;
    private IRoleService roleService;
    private PasswordEncoder passwordEncoder;
    private UserEntityToDTOMapper mapper;
    private ZoneEntityToDTOMapper zoneMapper;
    private RoleEntityToDTOMapper roleMapper;
    private DepartmentEntityToDTOMapper departmentMapper;

    @Override
    public List<UserResponseDTO> getAllUsers(Pageable pageable) {
        Page<User> userList = userRepository.findAll(pageable);
        List<UserResponseDTO> responseDTO = mapper.convert(userList);
        for (UserResponseDTO user : responseDTO) {
            DepartmentResponseDTO departmentDTO = departmentService.getDepartmentById(user.getDepartmentId());
            user.setDepartmentManagerFirstName(departmentDTO.getDepartmentManagerFirstName());
            user.setDepartmentManagerLastName(departmentDTO.getDepartmentManagerLastName());
            user.setGroupManagerFirstName(departmentDTO.getGroupManagerFirstName());
            user.setGroupManagerLastName(departmentDTO.getGroupManagerLastName());
        }
        return responseDTO;
    }

    @Override
    public UserResponseDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User Not Found"));
        UserResponseDTO responseDTO = mapper.toDTO(user);
        /*DepartmentResponseDTO departmentDTO = departmentService.getDepartmentById(user.getDepartment().getId());
        responseDTO.setDepartmentManagerFirstName(departmentDTO.getDepartmentManagerFirstName());
        responseDTO.setDepartmentManagerLastName(departmentDTO.getDepartmentManagerLastName());
        responseDTO.setGroupManagerFirstName(departmentDTO.getGroupManagerFirstName());
        responseDTO.setGroupManagerLastName(departmentDTO.getGroupManagerLastName());*/
        return responseDTO;
    }

    @Override
    public UserResponseDTO createUser(UserCreateRequestDTO userCreateRequestDTO) {
        RoleResponseDTO roleDTO = roleService.getRoleById(userCreateRequestDTO.getRoleId());
        Role role = roleMapper.responseDTOToEntity(roleDTO);
        ZoneResponseDTO zoneDTO = zoneService.getZoneById(userCreateRequestDTO.getZoneId());
        Zone zone = zoneMapper.responseDTOToEntity(zoneDTO);
        /*DepartmentResponseDTO departmentDTO = departmentService.getDepartmentById(userCreateRequestDTO.getDepartmentId());
        User groupManager = userRepository.findById(departmentDTO.getGroupManagerId()).orElseThrow(() -> new EntityNotFoundException("User Not Found"));
        User departmentManager = userRepository.findById(departmentDTO.getDepartmentManagerId()).orElseThrow(() -> new EntityNotFoundException("User Not Found"));*/
        User toSave = mapper.toEntity(userCreateRequestDTO);
        toSave.setRole(role);
        toSave.setZone(zone);
        //toSave.setDepartment(department);
        //user.setPassword(passwordEncoder.encode(userRequestDTO.getPassword())); //update
        User newUser = userRepository.save(toSave);
        UserResponseDTO result = mapper.toDTO(newUser);
        /*result.setDepartmentManagerFirstName(departmentManager.getFirstName());
        result.setDepartmentManagerLastName(departmentManager.getLastName());
        result.setGroupManagerFirstName(groupManager.getFirstName());
        result.setGroupManagerLastName(groupManager.getLastName());*/
        return result;
    }

    @Override
    public UserResponseDTO updateUser(UserUpdateRequestDTO userUpdateRequestDTO) {
        User user = userRepository.findById(userUpdateRequestDTO.getId()).orElseThrow(() -> new EntityNotFoundException("User Not Found"));
        RoleResponseDTO roleDTO = roleService.getRoleById(userUpdateRequestDTO.getRoleId());
        Role role = roleMapper.responseDTOToEntity(roleDTO);
        ZoneResponseDTO zoneDTO = zoneService.getZoneById(userUpdateRequestDTO.getZoneId());
        Zone zone = zoneMapper.responseDTOToEntity(zoneDTO);
        DepartmentResponseDTO departmentDTO = departmentService.getDepartmentById(userUpdateRequestDTO.getDepartmentId());
        Department department = departmentMapper.responseDTOToEntity(departmentDTO);
        User toUpdate = mapper.toEntity(userUpdateRequestDTO);
        toUpdate.setRole(role);
        toUpdate.setZone(zone);
        toUpdate.setDepartment(department);
        toUpdate.setRegistrationNumber(user.getRegistrationNumber());
        User result = userRepository.save(toUpdate);
        return mapper.toDTO(result);
    }

    @Override
    @Transactional
    public void deleteUsersByIds(List<Long> ids) {
        userRepository.deleteByIdIn(ids);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
