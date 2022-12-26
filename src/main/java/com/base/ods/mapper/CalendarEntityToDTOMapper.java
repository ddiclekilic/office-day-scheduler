package com.base.ods.mapper;

import com.base.ods.domain.Calendar;
import com.base.ods.services.requests.CalendarCreateRequestDTO;
import com.base.ods.services.requests.CalendarUpdateRequestDTO;
import com.base.ods.services.responses.CalendarResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CalendarEntityToDTOMapper {
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "user.firstName", target = "userFirstName")
    @Mapping(source = "user.lastName", target = "userLastName")
    @Mapping(source = "user.registrationNumber", target = "registrationNumber")
    @Mapping(source = "user.email", target = "userEmail")
    CalendarResponseDTO toDTO(Calendar calendar);

    @Mapping(source = "userId", target = "user.id")
    Calendar responseDTOToEntity(CalendarResponseDTO calendarResponseDTO);

    @Mapping(source = "userId", target = "user.id")
    Calendar toEntity(CalendarCreateRequestDTO calendarCreateRequestDTO);

    Calendar toEntity(CalendarUpdateRequestDTO calendarUpdateRequestDTO);

    List<CalendarResponseDTO> convert(Page<Calendar> calendars);

    List<CalendarResponseDTO> toDTOList(List<Calendar> calendarList);

}
