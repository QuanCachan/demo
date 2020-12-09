package fr.mirabeau.demo.controller;

import fr.mirabeau.demo.entity.Zone;
import fr.mirabeau.demo.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public List<Zone> getAllZones(@RequestParam(name = "inventoryId", required = false)
                                          String inventoryId) {
        if (inventoryId == null) {
            return zoneService.getAllZones();
        } else {
            return zoneService.getZonesByInventoryId(inventoryId);
        }
    }

    @PostMapping("")
    public Zone createZone(@RequestBody Zone zone) {
        return zoneService.createZone(zone);
    }

    @DeleteMapping(value = "/zones/{id}")
    public ResponseEntity<String> deleteZone(@PathVariable String id) {

        return zoneService.deleteZone(id);

       // return new ResponseEntity<String>(id, HttpStatus.OK);
    }
}
