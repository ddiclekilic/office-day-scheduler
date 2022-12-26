package com.base.ods.controllers;


import com.base.ods.controllers.requests.ScheduleCreateRequest;
import com.base.ods.controllers.requests.ScheduleUpdateRequest;
import com.base.ods.controllers.responses.ScheduleResponse;
import com.base.ods.mapper.ScheduleResponseToDTOMapper;
import com.base.ods.services.IScheduleService;
import com.base.ods.services.requests.ScheduleCreateRequestDTO;
import com.base.ods.services.requests.ScheduleUpdateRequestDTO;
import com.base.ods.services.responses.ScheduleResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/schedule")
@AllArgsConstructor
public class ScheduleController {
    private IScheduleService scheduleService;
    private ScheduleResponseToDTOMapper mapper;

    @GetMapping
    public ResponseEntity<List<ScheduleResponse>> getAllSchedules(Pageable pageable) {
        List<ScheduleResponseDTO> responseDTO = scheduleService.getAllSchedules(pageable);
        List<ScheduleResponse> result = mapper.toResponseList(responseDTO);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponse> getScheduleById(@PathVariable Long id) {
        ScheduleResponseDTO responseDTO = scheduleService.getScheduleById(id);
        ScheduleResponse result = mapper.toResponse(responseDTO);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<ScheduleResponse> createSchedule(@Valid @RequestBody ScheduleCreateRequest scheduleCreateRequest) {
        ScheduleCreateRequestDTO requestDTO = mapper.toDTO(scheduleCreateRequest);
        ScheduleResponseDTO responseDTO = scheduleService.createSchedule(requestDTO);
        ScheduleResponse result = mapper.toResponse(responseDTO);
        return ResponseEntity.ok(result);
    }

    @PutMapping
    public ResponseEntity<ScheduleResponse> updateSchedule(@Valid @RequestBody ScheduleUpdateRequest scheduleUpdateRequest) {
        ScheduleUpdateRequestDTO requestDTO = mapper.toDTO(scheduleUpdateRequest);
        ScheduleResponseDTO responseDTO = scheduleService.updateSchedule(requestDTO);
        ScheduleResponse result = mapper.toResponse(responseDTO);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{ids}")
    public void deleteScheduleById(@PathVariable List<Long> ids) {
        scheduleService.deleteSchedulesByIds(ids);
    }
}
