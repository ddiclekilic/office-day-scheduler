package com.base.ods.services.impl;

import com.base.ods.domain.OutOfOfficeDay;
import com.base.ods.exception.EntityNotFoundException;
import com.base.ods.mapper.OutOfOfficeDayEntityToDTOMapper;
import com.base.ods.repository.OutOfOfficeDayRepository;
import com.base.ods.services.IOutOfOfficeDayService;
import com.base.ods.services.requests.OutOfOfficeDayCreateRequestDTO;
import com.base.ods.services.requests.OutOfOfficeDayUpdateRequestDTO;
import com.base.ods.services.responses.OutOfOfficeDayResponseDTO;
import com.base.ods.util.constants.Messages;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Log4j2
public class OutOfOfficeDayServiceImpl implements IOutOfOfficeDayService {
    private OutOfOfficeDayRepository outOfOfficeDayRepository;
    private OutOfOfficeDayEntityToDTOMapper mapper;

    @Override
    public List<OutOfOfficeDayResponseDTO> getAllOutOfOfficeDays() {
        List<OutOfOfficeDay> outOfOfficeDayList = outOfOfficeDayRepository.findAll();
        return mapper.toDTOList(outOfOfficeDayList);
    }

    @Override
    public OutOfOfficeDayResponseDTO getOutOfOfficeDayById(Long id) {
        OutOfOfficeDay outOfOfficeDay = outOfOfficeDayRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(Messages.OUT_OF_OFFICE_DAY_NOT_FOUND + id));
        return mapper.toDTO(outOfOfficeDay);
    }

    @Override
    public OutOfOfficeDayResponseDTO createOutOfOfficeDay(OutOfOfficeDayCreateRequestDTO outOfOfficeDay) {
        OutOfOfficeDay toSave = mapper.toEntity(outOfOfficeDay);
        OutOfOfficeDay result = outOfOfficeDayRepository.save(toSave);
        return mapper.toDTO(result);
    }

    @Override
    public OutOfOfficeDayResponseDTO updateOutOfOfficeDay(OutOfOfficeDayUpdateRequestDTO outOfOfficeDay) {
        OutOfOfficeDay officeDay = outOfOfficeDayRepository.findById(outOfOfficeDay.getId()).orElseThrow(() -> new EntityNotFoundException(Messages.OUT_OF_OFFICE_DAY_NOT_FOUND + outOfOfficeDay.getId()));
        OutOfOfficeDay toUpdate = mapper.toEntity(outOfOfficeDay);
        OutOfOfficeDay result = outOfOfficeDayRepository.save(toUpdate);
        return mapper.toDTO(result);
    }

    @Override
    @Transactional
    public void deleteOutOfOfficeDaysByIds(List<Long> ids) {
        for (Long id : ids) {
            if (!outOfOfficeDayRepository.existsById(id)) {
                throw new EntityNotFoundException(Messages.OUT_OF_OFFICE_DAY_NOT_FOUND + id);
            }
        }
        outOfOfficeDayRepository.deleteByIdIn(ids);
    }
}
