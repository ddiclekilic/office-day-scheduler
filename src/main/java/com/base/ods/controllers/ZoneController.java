package com.base.ods.controllers;

import com.base.ods.entities.Zone;
import com.base.ods.services.IZoneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zones")
public class ZoneController {
    private IZoneService zoneService;

    public ZoneController(IZoneService zoneService) {
        this.zoneService = zoneService;
    }
    @GetMapping
    public List<Zone> getAllZones(){
        return zoneService.getAllZones();
    }
    @GetMapping("/{zoneId}")
    public Zone getZoneById(@PathVariable Long zoneId){
        return zoneService.getZoneById(zoneId);
    }

    @DeleteMapping("/{zoneId}")
    public void deleteZone(@PathVariable Long zoneId){
        zoneService.deleteZoneById(zoneId);
    }
}
