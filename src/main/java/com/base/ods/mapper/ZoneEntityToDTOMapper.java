package com.base.ods.mapper;

import com.base.ods.domain.Zone;
import com.base.ods.services.requests.ZoneCreateRequestDTO;
import com.base.ods.services.requests.ZoneUpdateRequestDTO;
import com.base.ods.services.responses.ZoneResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ZoneEntityToDTOMapper {
    ZoneResponseDTO toDTO(Zone zone);

    Zone responseDTOToEntity(ZoneResponseDTO zoneResponseDTO);

    Zone toEntity(ZoneCreateRequestDTO zoneCreateRequestDTO);

    Zone toEntity(ZoneUpdateRequestDTO zoneUpdateRequestDTO);

    List<ZoneResponseDTO> toDTOList(List<Zone> zoneList);
}
