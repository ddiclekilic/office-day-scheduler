package com.base.ods.services.impl;

import com.base.ods.domain.Zone;
import com.base.ods.repository.ZoneRepository;
import com.base.ods.services.IZoneService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Log4j2
public class ZoneServiceImpl implements IZoneService {
    private ZoneRepository zoneRepository;

    @Override
    public List<Zone> getAllZones() {
        return zoneRepository.findAll();
    }

    @Override
    public Zone getZoneById(Long zoneId) {
        Zone zone = zoneRepository.findById(zoneId).orElse(null);
        if (zone != null)
            return zone;
        else {
            log.warn("Zone not found by given {} id number.", zoneId);
            return null;
        }
    }

    @Override
    public Zone createZone(Zone zone) {
        return zoneRepository.save(zone);
    }

    @Override
    public Zone updateZoneById(Long zoneId, Zone zone) {
        Optional<Zone> zoneUpdate = zoneRepository.findById(zoneId);
        if (zoneUpdate.isPresent()) {
            Zone toUpdate = zoneUpdate.get();
            toUpdate.setZoneName(zone.getZoneName());
            toUpdate.setTransportChoice(zone.getTransportChoice());
            toUpdate.setCode(zone.getCode());
            toUpdate.setUpperBound(zone.getUpperBound());
            toUpdate.setLowerBound(zone.getLowerBound());
            toUpdate.setPrice(zone.getPrice());
            zoneRepository.save(toUpdate);
            log.info("Zone with id {} updated.", toUpdate.getId());
            return toUpdate;
        } else {
            log.warn("There is no zone information in the database with {} id number.", zoneId);
            return null;
        }
    }

    @Override
    public void deleteZoneById(Long zoneId) {
        Optional<Zone> zone = zoneRepository.findById(zoneId);
        if (zone.isPresent()) {
            zoneRepository.deleteById(zone.get().getId());
            log.info("Zone with id number {} deleted", zoneId);
        } else
            log.warn("There is no zone information in the database with {} id number.", zoneId);    }
}
