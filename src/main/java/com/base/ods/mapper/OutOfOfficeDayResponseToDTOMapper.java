package com.base.ods.mapper;

import com.base.ods.controllers.requests.OutOfOfficeDayCreateRequest;
import com.base.ods.controllers.requests.OutOfOfficeDayUpdateRequest;
import com.base.ods.controllers.responses.OutOfOfficeDayResponse;
import com.base.ods.services.requests.OutOfOfficeDayCreateRequestDTO;
import com.base.ods.services.requests.OutOfOfficeDayUpdateRequestDTO;
import com.base.ods.services.responses.OutOfOfficeDayResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OutOfOfficeDayResponseToDTOMapper {
    OutOfOfficeDayResponse toResponse(OutOfOfficeDayResponseDTO outOfOfficeDayResponseDTO);

    OutOfOfficeDayCreateRequestDTO toDTO(OutOfOfficeDayCreateRequest outOfOfficeDayCreateRequest);

    OutOfOfficeDayUpdateRequestDTO toDTO(OutOfOfficeDayUpdateRequest outOfOfficeDayUpdateRequest);

    List<OutOfOfficeDayResponse> toResponseList(List<OutOfOfficeDayResponseDTO> outOfOfficeDayList);
}
