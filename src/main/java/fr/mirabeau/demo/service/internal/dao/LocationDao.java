package fr.mirabeau.demo.service.internal.dao;

import fr.mirabeau.demo.entity.Location;
import fr.mirabeau.demo.entity.Zone;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LocationDao {
    /**
     * Get location by given name
     *
     * @param name : location name
     * @return location with the same name
     */
    List<Location> getLocationByName(String name);

    /**
     * Get all locations
     *
     * @return all locations
     */
    List<Location> getAllLocations();

    Location createLocation(Location location);

    ResponseEntity<String> deleteLocation(String id);

    /**
     * Create a new Zone for current location
     *
     * @return location with new Zone
     */
    Location createLocationZone(Zone zone);
}
