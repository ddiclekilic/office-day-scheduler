package com.base.ods.controllers;

import com.base.ods.entities.Department;
import com.base.ods.services.IDepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/{departments}")
public class DepartmentController {
    private IDepartmentService departmentService;

    public DepartmentController(IDepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartments();
    }
    @GetMapping("/{departmentId}")
    public Department getDepartmentById(@PathVariable Long departmentId){
        return departmentService.getDepartmentById(departmentId);
    }
    @DeleteMapping("/{departmentId}")
    public void deleteDepartmentById(@PathVariable Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
    }
}
