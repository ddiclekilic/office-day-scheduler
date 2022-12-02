package com.base.ods.controllers;

import com.base.ods.domain.Schedule;
import com.base.ods.requests.ScheduleCreateRequest;
import com.base.ods.requests.ScheduleUpdateRequest;
import com.base.ods.services.IScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/schedule")
@AllArgsConstructor
public class ScheduleController {
    private IScheduleService scheduleService;
    @GetMapping
    @PreAuthorize("hasAnyAuthority('MANAGER','SUPER_USER')")
    public List<Schedule> getAllSchedules(@RequestParam Optional<Long> userId,@RequestParam Optional<String> dateMonth,@RequestParam Optional<String> dateYear){
        return scheduleService.getAllSchedules(userId, dateMonth, dateYear);
    }
    @GetMapping("/{scheduleId}")
    public Schedule getScheduleById(@PathVariable Long scheduleId){
        return scheduleService.getScheduleById(scheduleId);
    }
    @PostMapping
    public Schedule createSchedule(@RequestBody ScheduleCreateRequest scheduleCreateRequest){
        return scheduleService.createSchedule(scheduleCreateRequest);
    }
    @PutMapping("/{scheduleId}")
    public Schedule updateScheduleById(@PathVariable Long scheduleId, @RequestBody ScheduleUpdateRequest scheduleUpdateRequest){
        return scheduleService.updateScheduleById(scheduleId, scheduleUpdateRequest);
    }
    @DeleteMapping("/{scheduleId}")
    public void deleteScheduleById(@PathVariable Long scheduleId){
        scheduleService.deleteScheduleById(scheduleId);
    }
}
