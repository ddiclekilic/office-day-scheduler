package com.base.ods.services.impl;

import com.base.ods.entities.Department;
import com.base.ods.entities.User;
import com.base.ods.repos.DepartmentRepository;
import com.base.ods.requests.DepartmentRequest;
import com.base.ods.services.IDepartmentService;
import com.base.ods.services.IUserService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements IDepartmentService {
    private DepartmentRepository departmentRepository;
    private IUserService userService;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository, @Lazy IUserService userService) {
        this.departmentRepository = departmentRepository;
        this.userService=userService;
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId).orElse(null);
    }

    @Override
    public Department createDepartment(DepartmentRequest departmentCreateRequest) {
        User departmentManager=userService.getUserById(departmentCreateRequest.getDepartmentManagerId());
        User groupManager=userService.getUserById(departmentCreateRequest.getGroupManagerId());
        if(departmentManager!=null && groupManager!=null){
            Department toSave=new Department();
            toSave.setDepartmentCode(departmentCreateRequest.getDepartmentCode());
            toSave.setGroupCode(departmentCreateRequest.getGroupCode());
            toSave.setDepartmentManager(departmentManager);
            toSave.setGroupManager(groupManager);
            return departmentRepository.save(toSave);
        }else
            return null;
    }

    @Override
    public Department updateDepartmentById(Long departmentId, DepartmentRequest departmentUpdateRequest) {
        Optional<Department> department=departmentRepository.findById(departmentId);
        User departmentManager=userService.getUserById(departmentUpdateRequest.getDepartmentManagerId());
        User groupManager=userService.getUserById(departmentUpdateRequest.getGroupManagerId());
        if(department.isPresent() && departmentManager!=null && groupManager!=null){
            Department toUpdate=department.get();
            toUpdate.setDepartmentCode(departmentUpdateRequest.getDepartmentCode());
            toUpdate.setGroupCode(departmentUpdateRequest.getGroupCode());
            toUpdate.setDepartmentManager(departmentManager);
            toUpdate.setGroupManager(groupManager);
            return departmentRepository.save(toUpdate);
        }else
            return null;
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }
}
