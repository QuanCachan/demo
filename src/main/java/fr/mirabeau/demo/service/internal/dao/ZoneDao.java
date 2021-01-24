package fr.mirabeau.demo.service.internal.dao;

import fr.mirabeau.demo.entity.Zone;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ZoneDao {
    /**
     * Get zone by given name
     *
     * @param name : zone name
     * @return List of Zone with the same name
     */
    List<Zone> getZoneByName(String name);

    /**
     * Get all ZONES
     *
     * @return all zones
     */
    List<Zone> getAllZones();

    /**
     * Create a new ZONE
     *
     * @return created Zone
     */
    Zone createZone(Zone zone);

    List<Zone> getZonesByInventoryId(String inventoryId);
    Zone getZoneByPublicId(String publicId);
    Zone updateZone(Zone zone);

    ResponseEntity<String> deleteZoneByPublicId(String publicId);
    ResponseEntity<String> deleteZone(String id);

}
