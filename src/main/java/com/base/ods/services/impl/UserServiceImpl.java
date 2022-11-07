package com.base.ods.services.impl;

import com.base.ods.domain.*;
import com.base.ods.repository.UserRepository;
import com.base.ods.requests.UserCreateRequest;
import com.base.ods.requests.UserUpdateRequest;
import com.base.ods.responses.UserResponse;
import com.base.ods.services.IDepartmentService;
import com.base.ods.services.IRoleService;
import com.base.ods.services.IUserService;
import com.base.ods.services.IZoneService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Log4j2
public class UserServiceImpl implements IUserService {
    private UserRepository userRepository;
    private IDepartmentService departmentService;
    private IZoneService zoneService;
    private IRoleService roleService;

    @Override
    public List<UserResponse> getAllUsersWithParam(Optional<Long> roleId, Optional<Long> departmentId) {
        List<User> list;
        if (roleId.isPresent())
            list = userRepository.findByRoleId(roleId.get());
        else if (departmentId.isPresent())
            list = userRepository.findByDepartmentId(departmentId.get());
        else
            list = userRepository.findAll();
        return list.stream().map(u -> new UserResponse(u)).collect(Collectors.toList());
    }

    @Override
    public User getUserById(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null)
            return user;
        else {
            log.warn("User not found by given {} id number.", userId);
            return null;
        }
    }

    @Override
    public User createUser(UserCreateRequest userCreateRequest) {
        Department department = departmentService.getDepartmentById(userCreateRequest.getDepartmentId());
        Zone zone = zoneService.getZoneById(userCreateRequest.getZoneId());
        Role role = roleService.getRoleById(userCreateRequest.getRoleId());
        if (department != null && zone != null && role != null) {
            User toSave = new User();
            toSave.setFirstName(userCreateRequest.getFirstName());
            toSave.setLastName(userCreateRequest.getLastName());
            toSave.setRegistrationNumber(userCreateRequest.getRegistrationNumber());
            toSave.setEmail(userCreateRequest.getEmail());
            toSave.setPassword(userCreateRequest.getPassword());
            toSave.setTransportChoice(userCreateRequest.getTransportChoice());
            toSave.setDepartment(department);
            toSave.setRole(role);
            toSave.setZone(zone);
            return userRepository.save(toSave);
        } else
            return null;
    }

    @Override
    public User updateUserById(Long userId, UserUpdateRequest userUpdateRequest) {
        Optional<User> user = userRepository.findById(userId);
        Department department = departmentService.getDepartmentById(userUpdateRequest.getDepartmentId());
        Zone zone = zoneService.getZoneById(userUpdateRequest.getZoneId());
        Role role = roleService.getRoleById(userUpdateRequest.getRoleId());
        if (user.isPresent() && department != null && zone != null && role != null) {
            User toUpdate = user.get();
            toUpdate.setEmail(userUpdateRequest.getEmail());
            toUpdate.setPassword(userUpdateRequest.getPassword());
            toUpdate.setFirstName(userUpdateRequest.getFirstName());
            toUpdate.setLastName(userUpdateRequest.getLastName());
            toUpdate.setTransportChoice(userUpdateRequest.getTransportChoice());
            toUpdate.setRole(role);
            toUpdate.setZone(zone);
            toUpdate.setDepartment(department);
            userRepository.save(toUpdate);
            log.info("User with id {} updated.", toUpdate.getId());
            return toUpdate;
        } else {
            log.warn("There is no user information in the database with {} id number.", userId);
            return null;
        }
    }

    @Override
    public void deleteUserById(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            userRepository.deleteById(user.get().getId());
            log.info("User with id number {} deleted", userId);
        } else
            log.warn("There is no user information in the database with {} id number.", userId);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
