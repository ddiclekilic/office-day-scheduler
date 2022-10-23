package com.base.ods.services.impl;

import com.base.ods.entities.Zone;
import com.base.ods.repos.ZoneRepository;
import com.base.ods.services.IZoneService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ZoneServiceImpl implements IZoneService {
    private ZoneRepository zoneRepository;

    public ZoneServiceImpl(ZoneRepository zoneRepository) {
        this.zoneRepository = zoneRepository;
    }

    @Override
    public List<Zone> getAllZones() {
        return zoneRepository.findAll();
    }

    @Override
    public Zone getZoneById(Long zoneId) {
        return zoneRepository.findById(zoneId).orElse(null);
    }

    @Override
    public Zone createZone(Zone zone) {
        return zoneRepository.save(zone);
    }

    @Override
    public Zone updateZoneById(Long zoneId, Zone zone) {
        Optional<Zone> zoneUpdate=zoneRepository.findById(zoneId);
        if(zoneUpdate.isPresent()){
            Zone toUpdate=zoneUpdate.get();
            toUpdate.setZoneName(zone.getZoneName());
            toUpdate.setTransportChoice(zone.getTransportChoice());
            toUpdate.setCode(zone.getCode());
            toUpdate.setUpperBound(zone.getUpperBound());
            toUpdate.setLowerBound(zone.getLowerBound());
            toUpdate.setPrice(zone.getPrice());
            return zoneRepository.save(toUpdate);
        }else
            return null;
    }


    @Override
    public void deleteZoneById(Long zoneId) {
        zoneRepository.deleteById(zoneId);
    }
}
