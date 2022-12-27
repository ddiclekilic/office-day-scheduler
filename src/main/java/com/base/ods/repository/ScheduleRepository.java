package com.base.ods.repository;

import com.base.ods.domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findByUserId(Long userId);
    List<Schedule> findByDateMonthAndDateYear(String dateMonth, String dateYear);
    void deleteByIdIn(List<Long> ids);
    boolean existsById(Long id);
}
