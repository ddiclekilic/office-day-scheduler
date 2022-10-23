package com.base.ods.repos;

import com.base.ods.entities.OutOfOfficeDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutOfOfficeDayRepository extends JpaRepository<OutOfOfficeDay, Long> {
}
