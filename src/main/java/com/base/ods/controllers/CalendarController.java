package com.base.ods.controllers;


import com.base.ods.controllers.requests.CalendarCreateRequest;
import com.base.ods.controllers.requests.CalendarUpdateRequest;
import com.base.ods.controllers.responses.CalendarResponse;
import com.base.ods.mapper.CalendarResponseToDTOMapper;
import com.base.ods.services.ICalendarService;
import com.base.ods.services.requests.CalendarCreateRequestDTO;
import com.base.ods.services.requests.CalendarUpdateRequestDTO;
import com.base.ods.services.responses.CalendarResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calendar")
@AllArgsConstructor
public class CalendarController {
    private ICalendarService calendarService;
    private CalendarResponseToDTOMapper mapper;

    @GetMapping
    public ResponseEntity<List<CalendarResponse>> getAllCalendars() {
        List<CalendarResponseDTO> calendarList = calendarService.getAllCalendars();
        List<CalendarResponse> result = mapper.toResponseList(calendarList);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CalendarResponse> getCalendarById(@PathVariable Long id) {
        CalendarResponseDTO calendarDTO = calendarService.getCalendarById(id);
        CalendarResponse result = mapper.toResponse(calendarDTO);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<CalendarResponse> createCalendar(@RequestBody CalendarCreateRequest calendarCreateRequest) {
        CalendarCreateRequestDTO requestDTO = mapper.toDTO(calendarCreateRequest);
        CalendarResponseDTO responseDTO = calendarService.createCalendar(requestDTO);
        CalendarResponse result = mapper.toResponse(responseDTO);
        return ResponseEntity.ok(result);
    }

    @PutMapping
    public ResponseEntity<CalendarResponse> updateCalendar(@RequestBody CalendarUpdateRequest calendarUpdateRequest) {
        CalendarUpdateRequestDTO requestDTO = mapper.toDTO(calendarUpdateRequest);
        CalendarResponseDTO responseDTO = calendarService.updateCalendar(requestDTO);
        CalendarResponse result = mapper.toResponse(responseDTO);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{ids}")
    public void deleteCalendarById(@PathVariable List<Long> ids) {
        calendarService.deleteCalendarsByIds(ids);
    }
}
