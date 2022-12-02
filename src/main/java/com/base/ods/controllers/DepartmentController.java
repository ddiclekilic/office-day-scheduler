package com.base.ods.controllers;

import com.base.ods.domain.Department;
import com.base.ods.requests.DepartmentRequest;
import com.base.ods.responses.DepartmentResponse;
import com.base.ods.services.IDepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
@AllArgsConstructor
public class DepartmentController {
    private IDepartmentService departmentService;

    @GetMapping
    public List<DepartmentResponse> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{departmentId}")
    public Department getDepartmentById(@PathVariable Long departmentId) {
        return departmentService.getDepartmentById(departmentId);
    }

    @PostMapping
    public Department createDepartment(@RequestBody DepartmentRequest departmentRequest) {
        return departmentService.createDepartment(departmentRequest);
    }

    @PutMapping("/{departmentId}")
    public Department updateDepartmentById(@PathVariable Long departmentId, @RequestBody DepartmentRequest departmentRequest) {
        return departmentService.updateDepartmentById(departmentId, departmentRequest);
    }

    @DeleteMapping("/{ids}")
    public void deleteDepartmentsByIds(@PathVariable List<Long> ids) {
        departmentService.deleteDepartmentsByIds(ids);
    }
}
