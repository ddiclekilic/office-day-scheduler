package com.base.ods.services;

import com.base.ods.entities.Calendar;
import com.base.ods.requests.CalendarCreateRequest;
import com.base.ods.requests.CalendarUpdateRequest;

import java.util.List;
import java.util.Optional;

public interface ICalendarService {
    List<Calendar> getAllCalendars(Optional<Long> userId, Optional<String> dateMonth, Optional<String> dateYear);
    Calendar getCalendarById(Long calendarId);
    Calendar createCalendar(CalendarCreateRequest calendarCreateRequest);
    Calendar updateCalendarById(Long calendarId, CalendarUpdateRequest calendarUpdateRequest);
    void deleteCalendarById(Long calendarId);
}
