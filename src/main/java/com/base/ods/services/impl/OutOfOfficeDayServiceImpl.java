package com.base.ods.services.impl;

import com.base.ods.domain.OutOfOfficeDay;
import com.base.ods.repository.OutOfOfficeDayRepository;
import com.base.ods.services.IOutOfOfficeDayService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Log4j2
public class OutOfOfficeDayServiceImpl implements IOutOfOfficeDayService {
    private OutOfOfficeDayRepository outOfOfficeDayRepository;

    @Override
    public List<OutOfOfficeDay> getAllOutOfOfficeDays() {
        return outOfOfficeDayRepository.findAll();
    }

    @Override
    public OutOfOfficeDay getOutOfOfficeDayById(Long outOfOfficeDayId) {
        OutOfOfficeDay outOfOfficeDay = outOfOfficeDayRepository.findById(outOfOfficeDayId).orElse(null);
        if (outOfOfficeDay != null)
            return outOfOfficeDay;
        else {
            log.warn("Out of office day not found by given {} id number.", outOfOfficeDayId);
            return null;
        }
    }

    @Override
    public OutOfOfficeDay createOutOfOfficeDay(OutOfOfficeDay outOfOfficeDay) {
        return outOfOfficeDayRepository.save(outOfOfficeDay);
    }

    @Override
    public OutOfOfficeDay updateOutOfOfficeDayById(Long outOfOfficeDayId, OutOfOfficeDay outOfOfficeDay) {
        Optional<OutOfOfficeDay> day = outOfOfficeDayRepository.findById(outOfOfficeDayId);
        if (day.isPresent()) {
            OutOfOfficeDay toUpdate = day.get();
            toUpdate.setDate(outOfOfficeDay.getDate());
            toUpdate.setDisplayName(outOfOfficeDay.getDisplayName());
            outOfOfficeDayRepository.save(toUpdate);
            log.info("Out of office day with id {} updated.", toUpdate.getId());
            return toUpdate;
        } else {
            log.warn("There is no out of office day information in the database with {} id number.", outOfOfficeDayId);
            return null;
        }
    }

    @Override
    @Transactional
    public void deleteOutOfOfficeDaysByIds(List<Long> ids) {
        outOfOfficeDayRepository.deleteByIdIn(ids);
    }
}
