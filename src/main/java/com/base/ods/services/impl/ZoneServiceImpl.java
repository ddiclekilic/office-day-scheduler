package com.base.ods.services.impl;

import com.base.ods.domain.Zone;
import com.base.ods.exception.ResourceNotFoundException;
import com.base.ods.mapper.ZoneEntityToDTOMapper;
import com.base.ods.repository.ZoneRepository;
import com.base.ods.services.IZoneService;
import com.base.ods.services.requests.ZoneCreateRequestDTO;
import com.base.ods.services.requests.ZoneUpdateRequestDTO;
import com.base.ods.services.responses.ZoneResponseDTO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
@Log4j2
public class ZoneServiceImpl implements IZoneService {
    private ZoneRepository zoneRepository;
    private ZoneEntityToDTOMapper mapper;

    @Override
    public List<ZoneResponseDTO> getAllZones() {
        List<Zone> zoneList = zoneRepository.findAll();
        return mapper.toDTOList(zoneList);
    }

    @Override
    public ZoneResponseDTO getZoneById(Long id) {
        Zone zone = zoneRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Zone Not Found"));
        return mapper.toDTO(zone);
    }

    @Override
    public ZoneResponseDTO createZone(ZoneCreateRequestDTO zoneCreateRequestDTO) {
        Zone toSave = mapper.toEntity(zoneCreateRequestDTO);
        Zone result = zoneRepository.save(toSave);
        return mapper.toDTO(result);
    }

    @Override
    public ZoneResponseDTO updateZone(ZoneUpdateRequestDTO zoneUpdateRequestDTO) {
        Zone zone = zoneRepository.findById(zoneUpdateRequestDTO.getId()).orElseThrow(() -> new ResourceNotFoundException("Zone Not Found"));
        if (zone != null) {
            Zone toUpdate = mapper.toEntity(zoneUpdateRequestDTO);
            Zone result = zoneRepository.save(toUpdate);
            return mapper.toDTO(result);
        } else
            return null;
    }

    @Override
    @Transactional
    public void deleteZonesByIds(List<Long> ids) {
        zoneRepository.deleteByIdIn(ids);
    }
}
