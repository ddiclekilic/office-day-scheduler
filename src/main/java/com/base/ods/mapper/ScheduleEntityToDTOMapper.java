package com.base.ods.mapper;


import com.base.ods.domain.Schedule;
import com.base.ods.services.requests.ScheduleCreateRequestDTO;
import com.base.ods.services.requests.ScheduleUpdateRequestDTO;
import com.base.ods.services.responses.ScheduleResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ScheduleEntityToDTOMapper {
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "user.firstName", target = "userFirstName")
    @Mapping(source = "user.lastName", target = "userLastName")
    @Mapping(source = "user.registrationNumber", target = "registrationNumber")
    @Mapping(source = "user.email", target = "userEmail")
    ScheduleResponseDTO toDTO(Schedule schedule);

    @Mapping(source = "userId", target = "user.id")
    Schedule responseDTOToEntity(ScheduleResponseDTO scheduleResponseDTO);

    @Mapping(source = "userId", target = "user.id")
    Schedule toEntity(ScheduleCreateRequestDTO scheduleCreateRequestDTO);

    Schedule toEntity(ScheduleUpdateRequestDTO scheduleUpdateRequestDTO);

    List<ScheduleResponseDTO> convert(Page<Schedule> schedules);

    List<ScheduleResponseDTO> toDTOList(List<Schedule> scheduleList);
}
