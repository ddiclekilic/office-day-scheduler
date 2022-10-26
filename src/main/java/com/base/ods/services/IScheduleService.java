package com.base.ods.services;

import com.base.ods.domain.Schedule;
import com.base.ods.requests.ScheduleCreateRequest;
import com.base.ods.requests.ScheduleUpdateRequest;

import java.util.List;
import java.util.Optional;

public interface IScheduleService {
    List<Schedule> getAllSchedules(Optional<Long> userId, Optional<String> dateMonth, Optional<String> dateYear);
    Schedule getScheduleById(Long scheduleId);
    Schedule createSchedule(ScheduleCreateRequest scheduleCreateRequest);
    Schedule updateScheduleById(Long scheduleId, ScheduleUpdateRequest scheduleUpdateRequest);
    void deleteScheduleById(Long scheduleId);
}
