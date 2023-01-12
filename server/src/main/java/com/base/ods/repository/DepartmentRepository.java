package com.base.ods.repository;

import com.base.ods.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    void deleteByIdIn(List<Long> ids);
}
