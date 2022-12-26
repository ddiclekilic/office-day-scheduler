package com.base.ods.services.impl;

import com.base.ods.domain.Schedule;
import com.base.ods.domain.User;
import com.base.ods.exception.EntityNotFoundException;
import com.base.ods.mapper.ScheduleEntityToDTOMapper;
import com.base.ods.mapper.UserEntityToDTOMapper;
import com.base.ods.repository.ScheduleRepository;
import com.base.ods.services.IScheduleService;
import com.base.ods.services.IUserService;
import com.base.ods.services.requests.ScheduleCreateRequestDTO;
import com.base.ods.services.requests.ScheduleUpdateRequestDTO;
import com.base.ods.services.responses.ScheduleResponseDTO;
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
public class ScheduleServiceImpl implements IScheduleService {
    private ScheduleRepository scheduleRepository;
    private IUserService userService;
    private ScheduleEntityToDTOMapper mapper;
    private UserEntityToDTOMapper userMapper;

    @Override
    public List<ScheduleResponseDTO> getAllSchedules(Pageable pageable) {
        Page<Schedule> scheduleList = scheduleRepository.findAll(pageable);
        List<ScheduleResponseDTO> responseDTO = mapper.convert(scheduleList);
        return responseDTO;
    }

    @Override
    public ScheduleResponseDTO getScheduleById(Long id) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Schedule Not Found"));
        return mapper.toDTO(schedule);
    }

    @Override
    public ScheduleResponseDTO createSchedule(ScheduleCreateRequestDTO scheduleCreateRequestDTO) {
        UserResponseDTO responseDTO = userService.getUserById(scheduleCreateRequestDTO.getUserId());
        User user = userMapper.responseDTOToEntity(responseDTO);
        Schedule toSave = mapper.toEntity(scheduleCreateRequestDTO);
        toSave.setUser(user);
        Schedule newSchedule = scheduleRepository.save(toSave);
        return mapper.toDTO(newSchedule);
    }

    @Override
    public ScheduleResponseDTO updateSchedule(ScheduleUpdateRequestDTO scheduleUpdateRequestDTO) {
        Schedule schedule = scheduleRepository.findById(scheduleUpdateRequestDTO.getId()).orElseThrow(() -> new EntityNotFoundException("Schedule Not Found"));
        UserResponseDTO userResponseDTO = userService.getUserById(schedule.getUser().getId());
        User user = userMapper.responseDTOToEntity(userResponseDTO);
        Schedule toUpdate = mapper.toEntity(scheduleUpdateRequestDTO);
        toUpdate.setUser(user);
        Schedule result = scheduleRepository.save(toUpdate);
        return mapper.toDTO(result);
    }

    @Override
    @Transactional
    public void deleteSchedulesByIds(List<Long> ids) {
        scheduleRepository.deleteByIdIn(ids);
    }
}
