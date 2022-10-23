package com.base.ods.services.impl;

import com.base.ods.entities.OutOfOfficeDay;
import com.base.ods.repos.OutOfOfficeDayRepository;
import com.base.ods.services.IOutOfOfficeDayService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OutOfOfficeDayServiceImpl implements IOutOfOfficeDayService {
    private OutOfOfficeDayRepository outOfOfficeDayRepository;

    public OutOfOfficeDayServiceImpl(OutOfOfficeDayRepository outOfOfficeDayRepository) {
        this.outOfOfficeDayRepository = outOfOfficeDayRepository;
    }

    @Override
    public List<OutOfOfficeDay> getAllOutOfOfficeDays() {
        return outOfOfficeDayRepository.findAll();
    }

    @Override
    public OutOfOfficeDay getOutOfOfficeDayById(Long outOfOfficeDayId) {
        return outOfOfficeDayRepository.findById(outOfOfficeDayId).orElse(null);
    }

    @Override
    public OutOfOfficeDay createOutOfOfficeDay(OutOfOfficeDay outOfOfficeDay) {
        return outOfOfficeDayRepository.save(outOfOfficeDay);
    }

    @Override
    public OutOfOfficeDay updateOutOfOfficeDayById(Long outOfOfficeDayId, OutOfOfficeDay outOfOfficeDay) {
        Optional<OutOfOfficeDay> day=outOfOfficeDayRepository.findById(outOfOfficeDayId);
        if(day.isPresent()){
            OutOfOfficeDay toUpdate=day.get();
            toUpdate.setDate(outOfOfficeDay.getDate());
            toUpdate.setDisplayName(outOfOfficeDay.getDisplayName());
            return outOfOfficeDayRepository.save(toUpdate);
        }else
            return null;
    }

    @Override
    public void deleteOfficeDayById(Long outOfOfficeDayId) {
        outOfOfficeDayRepository.deleteById(outOfOfficeDayId);
    }
}
