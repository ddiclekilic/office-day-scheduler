package com.base.ods.repository;

import com.base.ods.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    void deleteByIdIn(List<Long> ids);

    Optional<Role> findByRoleName(String roleName);
}
