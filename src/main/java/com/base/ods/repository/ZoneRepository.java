package com.base.ods.repository;

import com.base.ods.domain.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZoneRepository extends JpaRepository<Zone, Long> {
    void deleteByIdIn(List<Long> ids);
}
