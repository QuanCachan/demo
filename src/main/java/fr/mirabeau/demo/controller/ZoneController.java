package fr.mirabeau.demo.controller;

import fr.mirabeau.demo.entity.Zone;
import fr.mirabeau.demo.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("zones")
public class ZoneController {
    @Autowired
    private ZoneService zoneService;

    @GetMapping(value = "/{name}")
    public List<Zone> getZoneByName(@PathVariable String name) {
        return zoneService.getZoneByName(name);
    }

    @GetMapping("")
    public List<Zone> getAllZones() {
        return zoneService.getAllZones();
    }

    @PostMapping("")
    public Zone createZone(@RequestBody Zone zone) {
        return zoneService.createZone(zone);
    }
}
