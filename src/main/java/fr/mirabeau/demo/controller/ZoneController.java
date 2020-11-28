package fr.mirabeau.demo.controller;

import fr.mirabeau.demo.entity.Zone;
import fr.mirabeau.demo.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("zone")
public class ZoneController {
    @Autowired
    private ZoneService zoneService;

    @GetMapping()
    public List<Zone> getZoneByName(@RequestParam(name = "name") String name) {
        return zoneService.getZoneByName(name);
    }

    @GetMapping("/all")
    public List<Zone> getAllZones() {
        return zoneService.getAllZones();
    }

    @PostMapping("")
    public Zone createZone(@RequestBody Zone zone) {
        return zoneService.createZone(zone);
    }
}
