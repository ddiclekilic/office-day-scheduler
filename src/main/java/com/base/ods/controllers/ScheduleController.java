package com.base.ods.controllers;

import com.base.ods.entities.Schedule;
import com.base.ods.services.IScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {
    private IScheduleService scheduleService;

    public ScheduleController(IScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }
    @GetMapping
    public List<Schedule> getAllSchedules(){
        return scheduleService.getAllSchedules();
    }
}
