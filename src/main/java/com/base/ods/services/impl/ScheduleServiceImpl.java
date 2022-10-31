package com.base.ods.services.impl;

import com.base.ods.domain.Schedule;
import com.base.ods.domain.User;
import com.base.ods.repository.ScheduleRepository;
import com.base.ods.requests.ScheduleCreateRequest;
import com.base.ods.requests.ScheduleUpdateRequest;
import com.base.ods.services.IScheduleService;
import com.base.ods.services.IUserService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Log4j2
public class ScheduleServiceImpl implements IScheduleService {
    private ScheduleRepository scheduleRepository;
    private IUserService userService;

    @Override
    public List<Schedule> getAllSchedules(Optional<Long> userId, Optional<String> dateMonth, Optional<String> dateYear) {
        if (userId.isPresent())
            return scheduleRepository.findByUserId(userId.get());
        else if (dateMonth.isPresent() && dateYear.isPresent())
            return scheduleRepository.findByDateMonthAndDateYear(dateMonth.get(), dateYear.get());
        return scheduleRepository.findAll();
    }

    @Override
    public Schedule getScheduleById(Long scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElse(null);
        if (schedule != null)
            return schedule;
        else {
            log.warn("Schedule not found by given {} id number.", scheduleId);
            return null;
        }
    }

    @Override
    public Schedule createSchedule(ScheduleCreateRequest scheduleCreateRequest) {
        User user = userService.getUserById(scheduleCreateRequest.getUserId());
        if (user != null) {
            Schedule toSave = new Schedule();
            toSave.setDateMonth(scheduleCreateRequest.getDateMonth());
            toSave.setOfficeDay(scheduleCreateRequest.getOfficeDay());
            toSave.setDateYear(scheduleCreateRequest.getDateYear());
            toSave.setVacation(scheduleCreateRequest.getVacation());
            toSave.setTotalDay(scheduleCreateRequest.getTotalDay());
            toSave.setWorkFromHome(scheduleCreateRequest.getWorkFromHome());
            toSave.setReport(scheduleCreateRequest.getReport());
            toSave.setUser(user);
            return scheduleRepository.save(toSave);
        } else
            return null;
    }

    @Override
    public Schedule updateScheduleById(Long scheduleId, ScheduleUpdateRequest scheduleUpdateRequest) {
        Optional<Schedule> schedule = scheduleRepository.findById(scheduleId);
        if (schedule.isPresent()) {
            Schedule toUpdate = schedule.get();
            toUpdate.setDateYear(scheduleUpdateRequest.getDateYear());
            toUpdate.setDateMonth(scheduleUpdateRequest.getDateMonth());
            toUpdate.setVacation(scheduleUpdateRequest.getVacation());
            toUpdate.setReport(scheduleUpdateRequest.getReport());
            toUpdate.setOfficeDay(scheduleUpdateRequest.getOfficeDay());
            toUpdate.setWorkFromHome(scheduleUpdateRequest.getWorkFromHome());
            toUpdate.setTotalDay(scheduleUpdateRequest.getTotalDay());
            scheduleRepository.save(toUpdate);
            log.info("Schedule with id {} updated.", toUpdate.getId());
            return toUpdate;
        } else {
            log.warn("There is no schedule information in the database with {} id number.", scheduleId);
            return null;
        }
    }

    @Override
    public void deleteScheduleById(Long scheduleId) {
        Optional<Schedule> schedule = scheduleRepository.findById(scheduleId);
        if (schedule.isPresent()) {
            scheduleRepository.deleteById(schedule.get().getId());
            log.info("Schedule with id number {} deleted", scheduleId);
        } else
            log.warn("There is no schedule information in the database with {} id number.", scheduleId);
    }

}
