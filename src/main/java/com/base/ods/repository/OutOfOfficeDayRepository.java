package com.base.ods.repository;

import com.base.ods.domain.OutOfOfficeDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutOfOfficeDayRepository extends JpaRepository<OutOfOfficeDay, Long> {
}
