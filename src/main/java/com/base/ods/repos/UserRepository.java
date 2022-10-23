package com.base.ods.repos;

import com.base.ods.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByRoleId(Long roleId);
    List<User> findByDepartmentId(Long departmentId);
}
