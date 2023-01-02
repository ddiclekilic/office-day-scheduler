package com.base.ods.repository;

import com.base.ods.domain.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalendarRepository extends JpaRepository<Calendar, Long> {
    List<Calendar> findByUserId(Long userId);

    List<Calendar> findByDateMonthAndDateYear(String dateMonth, String dateYear);

    void deleteByIdIn(List<Long> ids);
}
