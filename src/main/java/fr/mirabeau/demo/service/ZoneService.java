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

    /**
     * deleted the selected in an inventory by it RavenDB ID (ex: "zones/67-A")
     *
     * @return list of resting Zones in that inventory
     */
    ResponseEntity<String> deleteZone(String id);

    /**
     * deleted the selected in an inventory by it public ID (ex: "67-A")
     *
     * @return list of resting Zones in that inventory
     */
    List<Zone> deleteZoneByPublicId(String publicId);

}
