package com.base.ods.services.impl;

import com.base.ods.entities.Calendar;
import com.base.ods.entities.User;
import com.base.ods.repos.CalendarRepository;
import com.base.ods.requests.CalendarCreateRequest;
import com.base.ods.requests.CalendarUpdateRequest;
import com.base.ods.services.ICalendarService;
import com.base.ods.services.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalendarServiceImpl implements ICalendarService {
    private CalendarRepository calendarRepository;
    private IUserService userService;

    public CalendarServiceImpl(CalendarRepository calendarRepository, IUserService userService) {
        this.calendarRepository = calendarRepository;
        this.userService=userService;
    }

    @Override
    public List<Calendar> getAllCalendars(Optional<Long> userId, Optional<String> dateMonth, Optional<String> dateYear) {
        if(userId.isPresent())
            return calendarRepository.findByUserId(userId.get());
        else if(dateMonth.isPresent() && dateYear.isPresent())
            return calendarRepository.findByDateMonthAndDateYear(dateMonth.get(), dateYear.get());
        return calendarRepository.findAll();
    }

    @Override
    public Calendar getCalendarById(Long calendarId) {
        return calendarRepository.findById(calendarId).orElse(null);
    }

    @Override
    public Calendar createCalendar(CalendarCreateRequest calendarCreateRequest) {
        User user=userService.getUserById(calendarCreateRequest.getUserId());
        if(user!=null){
            Calendar toSave=new Calendar();
            toSave.setDateMonth(calendarCreateRequest.getDateMonth());
            toSave.setDateYear(calendarCreateRequest.getDateYear());
            toSave.setDays(calendarCreateRequest.getDays());
            toSave.setUser(user);
            return calendarRepository.save(toSave);
        }else
            return null;
    }

    @Override
    public Calendar updateCalendarById(Long calendarId, CalendarUpdateRequest calendarUpdateRequest) {
        Optional<Calendar> calendar=calendarRepository.findById(calendarId);
        if(calendar.isPresent()){
            Calendar toUpdate=calendar.get();
            toUpdate.setDateMonth(calendarUpdateRequest.getDateMonth());
            toUpdate.setDateYear(calendarUpdateRequest.getDateYear());
            toUpdate.setDays(calendarUpdateRequest.getDays());
            return calendarRepository.save(toUpdate);
        }else
            return null;
    }

    @Override
    public void deleteCalendarById(Long calendarId) {
        calendarRepository.deleteById(calendarId);
    }
}
