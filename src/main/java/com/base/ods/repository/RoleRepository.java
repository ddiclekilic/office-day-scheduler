package com.base.ods.repository;

import com.base.ods.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    void deleteByIdIn(List<Long> ids);
    Role findByRoleName(String roleName);
    boolean existsById(Long id);
}
