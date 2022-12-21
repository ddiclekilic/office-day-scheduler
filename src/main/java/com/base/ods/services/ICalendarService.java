package com.base.ods.services;

import com.base.ods.services.requests.CalendarCreateRequestDTO;
import com.base.ods.services.requests.CalendarUpdateRequestDTO;
import com.base.ods.services.responses.CalendarResponseDTO;

import java.util.List;

public interface ICalendarService {
    List<CalendarResponseDTO> getAllCalendars();

    CalendarResponseDTO getCalendarById(Long id);

    CalendarResponseDTO createCalendar(CalendarCreateRequestDTO calendarCreateRequestDTO);

    CalendarResponseDTO updateCalendar(CalendarUpdateRequestDTO calendarUpdateRequestDTO);

    void deleteCalendarsByIds(List<Long> ids);
}
