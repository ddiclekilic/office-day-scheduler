package com.base.ods.services;

import com.base.ods.entities.Zone;

import java.util.List;

public interface IZoneService {
    List<Zone> getAllZones();
    Zone getZoneById(Long zoneId);
    void deleteZoneById(Long zoneId);
}
