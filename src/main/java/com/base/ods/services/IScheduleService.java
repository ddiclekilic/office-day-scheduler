package com.base.ods.services;


import com.base.ods.services.requests.ScheduleCreateRequestDTO;
import com.base.ods.services.requests.ScheduleUpdateRequestDTO;
import com.base.ods.services.responses.ScheduleResponseDTO;

import java.util.List;

public interface IScheduleService {
    List<ScheduleResponseDTO> getAllSchedules();

    ScheduleResponseDTO getScheduleById(Long id);

    ScheduleResponseDTO createSchedule(ScheduleCreateRequestDTO scheduleCreateRequestDTO);

    ScheduleResponseDTO updateSchedule(ScheduleUpdateRequestDTO scheduleUpdateRequestDTO);

    void deleteSchedulesByIds(List<Long> ids);

}
