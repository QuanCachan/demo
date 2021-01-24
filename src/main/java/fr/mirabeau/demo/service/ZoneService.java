package fr.mirabeau.demo.service;

import fr.mirabeau.demo.entity.Zone;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ZoneService {
    /**
     * Get ZONE by given name
     *
     * @param name : Zone name
     * @return Zone with the same name
     */
    List<Zone> getZoneByName(String name);

    /**
     * Get all ZONES
     *
     * @return all Zones
     */
    List<Zone> getAllZones();

    /**
     * Create a new ZONE
     *
     * @return created Zone
     */
    Zone createZone(Zone zone);

    Zone updateZone(Zone zone);

    /**
     * get all zones in an inventory
     *
     * @return list of Zone
     */
    List<Zone> getZonesByInventoryId(String inventoryId);

    Zone getZoneByPublicId(String publicId);

    ResponseEntity<String> deleteZone(String id);
    ResponseEntity<String> deleteZoneByPublicId(String publicId);

}
