package fr.mirabeau.demo.controller;

import fr.mirabeau.demo.entity.Location;
import fr.mirabeau.demo.entity.Zone;
import fr.mirabeau.demo.service.LocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("locations")
public class LocationController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LocationController.class);

    @Autowired
    private LocationService locationService;

    @GetMapping(value = "/{name}")
    public List<Location> getLocationByName(@PathVariable String name) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("get a Location by name");
        }
        return locationService.getLocationByName(name);
    }

    @GetMapping()
    public List<Location> getAllLocations() {
        LOGGER.info("get all Location");
        return locationService.getAllLocations();
    }

    @PostMapping("")
    public Location createLocation(@RequestBody Location location) {
        LOGGER.info("create location", location);
        return locationService.createLocation(location);
    }

    @PostMapping("/{locationId}")
    public Location createLocationZone(@PathVariable String locationId, @RequestBody Zone zone) {
        LOGGER.info("locationId", locationId);
        LOGGER.info("zone", zone);
        return locationService.createLocationZone(zone);
    }

    @DeleteMapping(value = "/locations/{id}")
    public ResponseEntity<String> deleteLocation(@PathVariable String id) {

        return locationService.deleteLocation(id);

        // return new ResponseEntity<String>(id, HttpStatus.OK);
    }
}
