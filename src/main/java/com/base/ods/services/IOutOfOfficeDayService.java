package com.base.ods.services;

import com.base.ods.services.requests.OutOfOfficeDayCreateRequestDTO;
import com.base.ods.services.requests.OutOfOfficeDayUpdateRequestDTO;
import com.base.ods.services.responses.OutOfOfficeDayResponseDTO;
import com.base.ods.util.IdWrapper;

import java.util.List;

public interface IOutOfOfficeDayService {
    List<OutOfOfficeDayResponseDTO> getAllOutOfOfficeDays();

    OutOfOfficeDayResponseDTO getOutOfOfficeDayById(Long id);

    OutOfOfficeDayResponseDTO createOutOfOfficeDay(OutOfOfficeDayCreateRequestDTO outOfOfficeDay);

    OutOfOfficeDayResponseDTO updateOutOfOfficeDay(OutOfOfficeDayUpdateRequestDTO outOfOfficeDay);

    void deleteOutOfOfficeDaysByIds(IdWrapper ids);
}
