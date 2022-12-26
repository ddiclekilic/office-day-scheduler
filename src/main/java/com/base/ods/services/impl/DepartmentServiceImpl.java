package com.base.ods.services.impl;

import com.base.ods.domain.Department;
import com.base.ods.exception.EntityNotFoundException;
import com.base.ods.mapper.DepartmentEntityToDTOMapper;
import com.base.ods.mapper.UserEntityToDTOMapper;
import com.base.ods.repository.DepartmentRepository;
import com.base.ods.services.IUserService;
import com.base.ods.services.IDepartmentService;
import com.base.ods.services.requests.DepartmentCreateRequestDTO;
import com.base.ods.services.requests.DepartmentUpdateRequestDTO;
import com.base.ods.services.responses.DepartmentResponseDTO;
import com.base.ods.services.responses.UserResponseDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Log4j2
public class DepartmentServiceImpl implements IDepartmentService {
    private DepartmentRepository departmentRepository;
    private IUserService userService;
    private DepartmentEntityToDTOMapper mapper;
    private UserEntityToDTOMapper userMapper;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository, @Lazy IUserService userService, DepartmentEntityToDTOMapper mapper) {
        this.departmentRepository = departmentRepository;
        this.userService = userService;
        this.mapper = mapper;
    }


    @Override
    public List<DepartmentResponseDTO> getAllDepartments() {
        List<Department> departmentList = departmentRepository.findAll();
        List<DepartmentResponseDTO> responseDTO = mapper.toDTOList(departmentList);
        for (DepartmentResponseDTO department : responseDTO) {
            UserResponseDTO departmentManager = userService.getUserById(department.getDepartmentManagerId());
            UserResponseDTO groupManager = userService.getUserById(department.getGroupManagerId());
            department.setDepartmentManagerFirstName(departmentManager.getFirstName());
            department.setDepartmentManagerLastName(departmentManager.getLastName());
            department.setGroupManagerFirstName(groupManager.getFirstName());
            department.setGroupManagerLastName(groupManager.getLastName());
        }
        return responseDTO;
    }

    @Override
    public DepartmentResponseDTO getDepartmentById(Long id) {
        Department department = departmentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Department Not Found"));
        DepartmentResponseDTO responseDTO = mapper.toDTO(department);
        UserResponseDTO groupManager = userService.getUserById(department.getGroupManagerId());
        UserResponseDTO departmentManager = userService.getUserById(department.getDepartmentManagerId());
        responseDTO.setDepartmentManagerFirstName(departmentManager.getFirstName());
        responseDTO.setDepartmentManagerLastName(departmentManager.getLastName());
        responseDTO.setGroupManagerFirstName(groupManager.getFirstName());
        responseDTO.setGroupManagerLastName(groupManager.getLastName());
        return responseDTO;
    }

    @Override
    public DepartmentResponseDTO createDepartment(DepartmentCreateRequestDTO departmentCreateRequestDTO) {
        UserResponseDTO groupManager = userService.getUserById(departmentCreateRequestDTO.getGroupManagerId());
        UserResponseDTO departmentManager = userService.getUserById(departmentCreateRequestDTO.getDepartmentManagerId());
        Department toSave = mapper.toEntity(departmentCreateRequestDTO);
        Department newDepartment = departmentRepository.save(toSave);
        DepartmentResponseDTO result = mapper.toDTO(newDepartment);
        result.setDepartmentManagerFirstName(departmentManager.getFirstName());
        result.setDepartmentManagerLastName(departmentManager.getLastName());
        result.setGroupManagerFirstName(groupManager.getFirstName());
        result.setGroupManagerLastName(groupManager.getLastName());
        return result;
    }

    @Override
    public DepartmentResponseDTO updateDepartment(DepartmentUpdateRequestDTO departmentUpdateRequestDTO) {
        Department department = departmentRepository.findById(departmentUpdateRequestDTO.getId()).orElseThrow(() -> new EntityNotFoundException("Department Not Found"));
        UserResponseDTO groupManager = userService.getUserById(departmentUpdateRequestDTO.getGroupManagerId());
        UserResponseDTO departmentManager = userService.getUserById(departmentUpdateRequestDTO.getDepartmentManagerId());
        Department toUpdate = mapper.toEntity(departmentUpdateRequestDTO);
        Department newDepartment = departmentRepository.save(toUpdate);
        DepartmentResponseDTO result = mapper.toDTO(newDepartment);
        result.setDepartmentManagerFirstName(departmentManager.getFirstName());
        result.setDepartmentManagerLastName(departmentManager.getLastName());
        result.setGroupManagerFirstName(groupManager.getFirstName());
        result.setGroupManagerLastName(groupManager.getLastName());
        return result;
    }

    @Override
    @Transactional
    public void deleteDepartmentsByIds(List<Long> ids) {
        departmentRepository.deleteByIdIn(ids);
    }
}
