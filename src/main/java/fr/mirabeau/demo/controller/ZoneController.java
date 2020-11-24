package fr.mirabeau.demo.controller;

import fr.mirabeau.demo.entity.Zone;
import fr.mirabeau.demo.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ZoneController {
    @Autowired
    private ZoneService zoneService;

    @GetMapping("/zone")
    public Zone getZoneByName(@RequestParam(name = "name") String name) {
        return zoneService.getZoneByName(name);
    }

    @GetMapping("/zones")
    public List<Zone> getAllZones() {
        return (List<Zone>) zoneService.getAllZones();
    }
}
