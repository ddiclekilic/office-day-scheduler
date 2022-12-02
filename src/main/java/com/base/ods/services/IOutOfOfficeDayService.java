package com.base.ods.services;

import com.base.ods.domain.OutOfOfficeDay;

import java.util.List;

public interface IOutOfOfficeDayService {
    List<OutOfOfficeDay> getAllOutOfOfficeDays();
    OutOfOfficeDay getOutOfOfficeDayById(Long outOfOfficeDayId);
    OutOfOfficeDay createOutOfOfficeDay(OutOfOfficeDay outOfOfficeDay);
    OutOfOfficeDay updateOutOfOfficeDayById(Long outOfOfficeDayId, OutOfOfficeDay outOfOfficeDay);
    void deleteOutOfOfficeDaysByIds(List<Long> ids);
}
