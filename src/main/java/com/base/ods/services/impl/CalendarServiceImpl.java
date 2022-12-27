package com.base.ods.services.impl;

import com.base.ods.domain.Calendar;
import com.base.ods.domain.User;
import com.base.ods.exception.EntityNotFoundException;
import com.base.ods.mapper.CalendarEntityToDTOMapper;
import com.base.ods.mapper.UserEntityToDTOMapper;
import com.base.ods.repository.CalendarRepository;
import com.base.ods.services.ICalendarService;
import com.base.ods.services.IUserService;
import com.base.ods.services.requests.CalendarCreateRequestDTO;
import com.base.ods.services.requests.CalendarUpdateRequestDTO;
import com.base.ods.services.responses.CalendarResponseDTO;
import com.base.ods.services.responses.UserResponseDTO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
@Log4j2
public class CalendarServiceImpl implements ICalendarService {
    private CalendarRepository calendarRepository;
    private IUserService userService;
    private CalendarEntityToDTOMapper mapper;
    private UserEntityToDTOMapper userMapper;

    @Override
    public List<CalendarResponseDTO> getAllCalendars(Pageable pageable) {
        Page<Calendar> calendarList = calendarRepository.findAll(pageable);
        List<CalendarResponseDTO> responseDTO = mapper.convert(calendarList);
        return responseDTO;
    }

    @Override
    public CalendarResponseDTO getCalendarById(Long id) {
        Calendar calendar = calendarRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Calendar Not Found"));
        return mapper.toDTO(calendar);
    }

    @Override
    public CalendarResponseDTO createCalendar(CalendarCreateRequestDTO calendarCreateRequestDTO) {
        UserResponseDTO responseDTO = userService.getUserById(calendarCreateRequestDTO.getUserId());
        User user = userMapper.responseDTOToEntity(responseDTO);
        Calendar toSave = mapper.toEntity(calendarCreateRequestDTO);
        toSave.setUser(user);
        Calendar newCalendar = calendarRepository.save(toSave);
        return mapper.toDTO(newCalendar);
    }

    @Override
    public CalendarResponseDTO updateCalendar(CalendarUpdateRequestDTO calendarUpdateRequestDTO) {
        Calendar calendar = calendarRepository.findById(calendarUpdateRequestDTO.getId()).orElseThrow(() -> new EntityNotFoundException("Calendar Not Found"));
        UserResponseDTO userResponseDTO = userService.getUserById(calendar.getUser().getId());
        User user = userMapper.responseDTOToEntity(userResponseDTO);
        Calendar toUpdate = mapper.toEntity(calendarUpdateRequestDTO);
        toUpdate.setUser(user);
        Calendar result = calendarRepository.save(toUpdate);
        return mapper.toDTO(result);
    }

    @Override
    @Transactional
    public void deleteCalendarsByIds(List<Long> ids) {
        for(Long id:ids){
            if(!calendarRepository.existsById(id)){
                throw new EntityNotFoundException("Calendar with id "+id+" not found");
            }
        }
        calendarRepository.deleteByIdIn(ids);
    }
}
