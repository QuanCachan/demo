package fr.mirabeau.demo.service;

import fr.mirabeau.demo.entity.Location;
import fr.mirabeau.demo.entity.Zone;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LocationService {
    /**
     * Get location by given name
     *
     * @param name : location name
     * @return location with the same name
     */
    List<Location> getLocationByName(String name);

    /**
     * Get all Locations
     *
     * @return all Locations
     */
    List<Location> getAllLocations();


    /**
     * Create a new location
     *
     * @return created location
     */
    Location createLocation(Location location);

    ResponseEntity<String> deleteLocation(String id);

    /**
     * Create a new Zone for current location
     *
     * @return location with new Zone
     */
    Location createLocationZone(Zone zone);
}
