package com.base.ods.services;

import com.base.ods.services.requests.CalendarCreateRequestDTO;
import com.base.ods.services.requests.CalendarUpdateRequestDTO;
import com.base.ods.services.responses.CalendarResponseDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICalendarService {
    List<CalendarResponseDTO> getAllCalendars(Pageable pageable);

    CalendarResponseDTO getCalendarById(Long id);

    CalendarResponseDTO createCalendar(CalendarCreateRequestDTO calendarCreateRequestDTO);

    CalendarResponseDTO updateCalendar(CalendarUpdateRequestDTO calendarUpdateRequestDTO);

    void deleteCalendarsByIds(List<Long> ids);
}
