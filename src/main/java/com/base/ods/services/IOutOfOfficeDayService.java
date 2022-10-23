package com.base.ods.services;

import com.base.ods.entities.OutOfOfficeDay;

import java.util.List;

public interface IOutOfOfficeDayService {
    List<OutOfOfficeDay> getAllOutOfOfficeDays();
    OutOfOfficeDay getOutOfOfficeDayById(Long outOfOfficeDayId);
    OutOfOfficeDay createOutOfOfficeDay(OutOfOfficeDay outOfOfficeDay);
    OutOfOfficeDay updateOutOfOfficeDayById(Long outOfOfficeDayId, OutOfOfficeDay outOfOfficeDay);
    void deleteOfficeDayById(Long outOfOfficeDayId);
}
