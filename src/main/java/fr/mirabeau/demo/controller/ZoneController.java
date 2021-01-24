package fr.mirabeau.demo.controller;

import fr.mirabeau.demo.entity.Zone;
import fr.mirabeau.demo.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping(value = "/{publicId}")
    public Zone getZoneByPublicId(@PathVariable String publicId) {
        return zoneService.getZoneByPublicId(publicId);
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

    @PostMapping("/{publicId}")
    public Zone updateZone(@PathVariable String publicId,@RequestBody Zone zone) {
        System.out.println("zone ==> " +zone.getPublicId());
        System.out.println("publicId ==> " +publicId);

        if(!zone.getPublicId().equals(publicId)) return null;
        System.out.println("OK");
        return zoneService.updateZone(zone);
    }

    @DeleteMapping(value = "/zones/{id}")
    public ResponseEntity<String> deleteZone(@PathVariable String id) {

        return zoneService.deleteZone(id);

       // return new ResponseEntity<String>(id, HttpStatus.OK);
    }
}
