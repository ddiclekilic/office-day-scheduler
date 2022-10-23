package com.base.ods.services;

import com.base.ods.entities.Zone;

import java.util.List;

public interface IZoneService {
    List<Zone> getAllZones();
    Zone getZoneById(Long zoneId);
    Zone createZone(Zone zone);
    Zone updateZoneById(Long zoneId, Zone zone);
    void deleteZoneById(Long zoneId);
}
