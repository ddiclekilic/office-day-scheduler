package com.base.ods.controllers;

import com.base.ods.domain.OutOfOfficeDay;
import com.base.ods.services.IOutOfOfficeDayService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/outofofficeday")
@AllArgsConstructor
public class OutOfOfficeDayController {
    private IOutOfOfficeDayService outOfOfficeDayService;

    @GetMapping
    public List<OutOfOfficeDay> getAllOutOfOfficeDays() {
        return outOfOfficeDayService.getAllOutOfOfficeDays();
    }

    @GetMapping("/{outOfOfficeDayId}")
    public OutOfOfficeDay getOutOfOfficeDayById(@PathVariable Long outOfOfficeDayId) {
        return outOfOfficeDayService.getOutOfOfficeDayById(outOfOfficeDayId);
    }

    @PostMapping
    public OutOfOfficeDay createOutOfOfficeDay(@RequestBody OutOfOfficeDay outOfOfficeDay) {
        return outOfOfficeDayService.createOutOfOfficeDay(outOfOfficeDay);
    }

    @PutMapping("/{outOfOfficeDayId}")
    public OutOfOfficeDay updateOutOfOfficeDayById(@PathVariable Long outOfOfficeDayId, @RequestBody OutOfOfficeDay outOfOfficeDay) {
        return outOfOfficeDayService.updateOutOfOfficeDayById(outOfOfficeDayId, outOfOfficeDay);
    }

    @DeleteMapping("/{outOfOfficeDayId}")
    public void deleteOfficeDayById(@PathVariable Long outOfOfficeDayId) {
        outOfOfficeDayService.deleteOfficeDayById(outOfOfficeDayId);
    }
}
