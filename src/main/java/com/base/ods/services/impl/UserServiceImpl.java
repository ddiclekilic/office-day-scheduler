package com.base.ods.services.impl;

import com.base.ods.entities.Department;
import com.base.ods.entities.Role;
import com.base.ods.entities.User;
import com.base.ods.entities.Zone;
import com.base.ods.repos.UserRepository;
import com.base.ods.requests.UserCreateRequest;
import com.base.ods.requests.UserUpdateRequest;
import com.base.ods.responses.UserResponse;
import com.base.ods.services.IDepartmentService;
import com.base.ods.services.IRoleService;
import com.base.ods.services.IUserService;
import com.base.ods.services.IZoneService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {
    private UserRepository userRepository;
    private IDepartmentService departmentService;
    private IZoneService zoneService;
    private IRoleService roleService;

    public UserServiceImpl(UserRepository userRepository,IDepartmentService departmentService, IZoneService zoneService,IRoleService roleService ) {
        this.userRepository = userRepository;
        this.departmentService=departmentService;
        this.zoneService=zoneService;
        this.roleService=roleService;
    }
    @Override
    public List<UserResponse> getAllUsersWithParam(Optional<Long> roleId, Optional<Long> departmentId) {
        List<User> list;
        if(roleId.isPresent())
            list= userRepository.findByRoleId(roleId.get());
        else if(departmentId.isPresent())
            list= userRepository.findByDepartmentId(departmentId.get());
        else
            list= userRepository.findAll();
        return list.stream().map(u->new UserResponse(u)).collect(Collectors.toList());
    }
    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }
    @Override
    public User createUser(UserCreateRequest userCreateRequest) {
        Department department=departmentService.getDepartmentById(userCreateRequest.getDepartmentId());
        Zone zone=zoneService.getZoneById(userCreateRequest.getZoneId());
        Role role=roleService.getRoleById(userCreateRequest.getRoleId());
        if(department!=null && zone!=null && role!=null){
            User toSave=new User();
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
        }else
            return null;
    }
    @Override
    public User updateUserById(Long userId, UserUpdateRequest userUpdateRequest) {
        Optional<User> user=userRepository.findById(userId);
        Department department=departmentService.getDepartmentById(userUpdateRequest.getDepartmentId());
        Zone zone=zoneService.getZoneById(userUpdateRequest.getZoneId());
        Role role=roleService.getRoleById(userUpdateRequest.getRoleId());
        if(user.isPresent() && department!=null && zone!=null && role!=null){
            User toUpdate=user.get();
            toUpdate.setEmail(userUpdateRequest.getEmail());
            toUpdate.setPassword(userUpdateRequest.getPassword());
            toUpdate.setFirstName(userUpdateRequest.getFirstName());
            toUpdate.setLastName(userUpdateRequest.getLastName());
            toUpdate.setTransportChoice(userUpdateRequest.getTransportChoice());
            toUpdate.setRole(role);
            toUpdate.setZone(zone);
            toUpdate.setDepartment(department);
            return userRepository.save(toUpdate);
        }else
            return null;
    }
    @Override
    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }


}
