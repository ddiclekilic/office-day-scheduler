package com.base.ods.services.impl;

import com.base.ods.domain.Department;
import com.base.ods.domain.User;
import com.base.ods.repository.DepartmentRepository;
import com.base.ods.requests.DepartmentRequest;
import com.base.ods.services.IDepartmentService;
import com.base.ods.services.IUserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class DepartmentServiceImpl implements IDepartmentService {
    private DepartmentRepository departmentRepository;
    private IUserService userService;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository, @Lazy IUserService userService) {
        this.departmentRepository = departmentRepository;
        this.userService = userService;
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long departmentId) {
        Department department = departmentRepository.findById(departmentId).orElse(null);
        if (department != null)
            return department;
        else {
            log.warn("Department not found by given {} id number.", departmentId);
            return null;
        }
    }

    @Override
    public Department createDepartment(DepartmentRequest departmentCreateRequest) {
        User departmentManager = userService.getUserById(departmentCreateRequest.getDepartmentManagerId());
        User groupManager = userService.getUserById(departmentCreateRequest.getGroupManagerId());
        if (departmentManager != null && groupManager != null) {
            Department toSave = new Department();
            toSave.setDepartmentCode(departmentCreateRequest.getDepartmentCode());
            toSave.setGroupCode(departmentCreateRequest.getGroupCode());
            toSave.setDepartmentManager(departmentManager);
            toSave.setGroupManager(groupManager);
            return departmentRepository.save(toSave);
        } else
            return null;
    }

    @Override
    public Department updateDepartmentById(Long departmentId, DepartmentRequest departmentUpdateRequest) {
        Optional<Department> department = departmentRepository.findById(departmentId);
        User departmentManager = userService.getUserById(departmentUpdateRequest.getDepartmentManagerId());
        User groupManager = userService.getUserById(departmentUpdateRequest.getGroupManagerId());
        if (department.isPresent() && departmentManager != null && groupManager != null) {
            Department toUpdate = department.get();
            toUpdate.setDepartmentCode(departmentUpdateRequest.getDepartmentCode());
            toUpdate.setGroupCode(departmentUpdateRequest.getGroupCode());
            toUpdate.setDepartmentManager(departmentManager);
            toUpdate.setGroupManager(groupManager);
            departmentRepository.save(toUpdate);
            log.info("Department with id {} updated.", toUpdate.getId());
            return toUpdate;
        } else {
            log.warn("There is no department information in the database with {} id number.", departmentId);
            return null;
        }
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        Optional<Department> department = departmentRepository.findById(departmentId);
        if (department.isPresent()) {
            departmentRepository.deleteById(department.get().getId());
            log.info("Department with id number {} deleted", departmentId);
        } else
            log.warn("There is no department information in the database with {} id number.", departmentId);
    }
}
