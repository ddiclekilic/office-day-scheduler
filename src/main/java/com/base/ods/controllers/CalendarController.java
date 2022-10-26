package com.base.ods.controllers;

import com.base.ods.domain.Calendar;
import com.base.ods.requests.CalendarCreateRequest;
import com.base.ods.requests.CalendarUpdateRequest;
import com.base.ods.services.ICalendarService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/calendar")
@AllArgsConstructor
public class CalendarController {
    private ICalendarService calendarService;
    @GetMapping
    public List<Calendar> getAllCalendars(@RequestParam Optional<Long> userId, @RequestParam Optional<String> dateMonth, @RequestParam Optional<String> dateYear){
        return calendarService.getAllCalendars(userId, dateMonth, dateYear);
    }
    @GetMapping("/{calendarId}")
    public Calendar getCalendarById(@PathVariable Long calendarId){
        return calendarService.getCalendarById(calendarId);
    }
    @PostMapping
    public Calendar createCalendar(@RequestBody CalendarCreateRequest calendarCreateRequest){
        return calendarService.createCalendar(calendarCreateRequest);
    }
    @PutMapping("/{calendarId}")
    public Calendar updateCalendarById(@PathVariable Long calendarId, @RequestBody CalendarUpdateRequest calendarUpdateRequest){
        return calendarService.updateCalendarById(calendarId, calendarUpdateRequest);
    }
    @DeleteMapping("/{calendarId}")
    public void deleteCalendarById(@PathVariable Long calendarId){
        calendarService.deleteCalendarById(calendarId);
    }
}
