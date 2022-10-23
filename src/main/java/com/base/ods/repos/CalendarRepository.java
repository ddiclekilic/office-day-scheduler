package com.base.ods.repos;

import com.base.ods.entities.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalendarRepository extends JpaRepository<Calendar, Long> {
    List<Calendar> findByUserId(Long userId);
    List<Calendar> findByDateMonthAndDateYear(String dateMonth, String dateYear);
}
