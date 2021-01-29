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

    /**
     * deleted the selected in an inventory by it public ID (ex: "67-A")
     *
     * @return list of resting Zones in that inventory
     */
    List<Zone> deleteZoneByPublicId(String publicId);

    /**
     * deleted the selected in an inventory by it RavenDB ID (ex: "zones/67-A")
     *
     * @return list of resting Zones in that inventory
     */
    ResponseEntity<String> deleteZone(String id);

}
