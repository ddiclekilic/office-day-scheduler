package com.base.ods.mapper;

import com.base.ods.domain.OutOfOfficeDay;
import com.base.ods.services.requests.OutOfOfficeDayCreateRequestDTO;
import com.base.ods.services.requests.OutOfOfficeDayUpdateRequestDTO;
import com.base.ods.services.responses.OutOfOfficeDayResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OutOfOfficeDayEntityToDTOMapper {
    OutOfOfficeDayResponseDTO toDTO(OutOfOfficeDay outOfOfficeDay);

    OutOfOfficeDay toEntity(OutOfOfficeDayCreateRequestDTO outOfOfficeDayCreateRequestDTO);

    OutOfOfficeDay toEntity(OutOfOfficeDayUpdateRequestDTO outOfOfficeDayUpdateRequestDTO);

    List<OutOfOfficeDayResponseDTO> toDTOList(List<OutOfOfficeDay> outOfOfficeDayList);
}
