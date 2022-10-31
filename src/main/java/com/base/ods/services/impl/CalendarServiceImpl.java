package com.base.ods.services.impl;

import com.base.ods.domain.Calendar;
import com.base.ods.domain.User;
import com.base.ods.repository.CalendarRepository;
import com.base.ods.requests.CalendarCreateRequest;
import com.base.ods.requests.CalendarUpdateRequest;
import com.base.ods.services.ICalendarService;
import com.base.ods.services.IUserService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Log4j2
public class CalendarServiceImpl implements ICalendarService {
    private CalendarRepository calendarRepository;
    private IUserService userService;

    @Override
    public List<Calendar> getAllCalendars(Optional<Long> userId, Optional<String> dateMonth, Optional<String> dateYear) {
        if (userId.isPresent())
            return calendarRepository.findByUserId(userId.get());
        else if (dateMonth.isPresent() && dateYear.isPresent())
            return calendarRepository.findByDateMonthAndDateYear(dateMonth.get(), dateYear.get());
        return calendarRepository.findAll();
    }

    @Override
    public Calendar getCalendarById(Long calendarId) {
        Calendar calendar = calendarRepository.findById(calendarId).orElse(null);
        if (calendar != null)
            return calendar;
        else {
            log.warn("Calendar not found by given {} id number.", calendarId);
            return null;
        }
    }

    @Override
    public Calendar createCalendar(CalendarCreateRequest calendarCreateRequest) {
        User user = userService.getUserById(calendarCreateRequest.getUserId());
        if (user != null) {
            Calendar toSave = new Calendar();
            toSave.setDateMonth(calendarCreateRequest.getDateMonth());
            toSave.setDateYear(calendarCreateRequest.getDateYear());
            toSave.setDays(calendarCreateRequest.getDays());
            toSave.setUser(user);
            return calendarRepository.save(toSave);
        } else
            return null;
    }

    @Override
    public Calendar updateCalendarById(Long calendarId, CalendarUpdateRequest calendarUpdateRequest) {
        Optional<Calendar> calendar = calendarRepository.findById(calendarId);
        if (calendar.isPresent()) {
            Calendar toUpdate = calendar.get();
            toUpdate.setDateMonth(calendarUpdateRequest.getDateMonth());
            toUpdate.setDateYear(calendarUpdateRequest.getDateYear());
            toUpdate.setDays(calendarUpdateRequest.getDays());
            calendarRepository.save(toUpdate);
            log.info("Calendar with id {} updated.", toUpdate.getId());
            return toUpdate;
        } else {
            log.warn("There is no calendar information in the database with {} id number.", calendarId);
            return null;
        }
    }

    @Override
    public void deleteCalendarById(Long calendarId) {
        Optional<Calendar> calendar = calendarRepository.findById(calendarId);
        if (calendar.isPresent()) {
            calendarRepository.deleteById(calendar.get().getId());
            log.info("Calendar with id number {} deleted", calendarId);
        } else
            log.warn("There is no calendar information in the database with {} id number.", calendarId);
    }
}
