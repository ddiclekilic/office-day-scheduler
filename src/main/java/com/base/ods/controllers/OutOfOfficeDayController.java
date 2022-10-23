package com.base.ods.controllers;

import com.base.ods.entities.OutOfOfficeDay;
import com.base.ods.services.IOutOfOfficeDayService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/outofofficedays")
public class OutOfOfficeDayController {
    private IOutOfOfficeDayService outOfOfficeDayService;

    public OutOfOfficeDayController(IOutOfOfficeDayService outOfOfficeDayService) {
        this.outOfOfficeDayService = outOfOfficeDayService;
    }
    @GetMapping
    public List<OutOfOfficeDay> getAllOutOfOfficeDays(){
        return outOfOfficeDayService.getAllOutOfOfficeDays();
    }
    @GetMapping("/{outOfOfficeDayId}")
    public OutOfOfficeDay getOutOfOfficeDayById(@PathVariable Long outOfOfficeDayId){
        return outOfOfficeDayService.getOutOfOfficeDayById(outOfOfficeDayId);
    }
    @PostMapping
    public OutOfOfficeDay createOutOfOfficeDay(@RequestBody OutOfOfficeDay outOfOfficeDay){
        return outOfOfficeDayService.createOutOfOfficeDay(outOfOfficeDay);
    }
    @PutMapping("/{outOfOfficeDayId}")
    public OutOfOfficeDay updateOutOfOfficeDayById(@PathVariable Long outOfOfficeDayId, @RequestBody OutOfOfficeDay outOfOfficeDay){
        return outOfOfficeDayService.updateOutOfOfficeDayById(outOfOfficeDayId, outOfOfficeDay);
    }
    @DeleteMapping("/{outOfOfficeDayId}")
    public void deleteOfficeDayById(@PathVariable Long outOfOfficeDayId){
        outOfOfficeDayService.deleteOfficeDayById(outOfOfficeDayId);
    }
}
