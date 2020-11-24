package fr.mirabeau.demo.service.internal.dao;

import fr.mirabeau.demo.entity.Zone;

import java.util.List;

public interface ZoneDao {
    /**
     * Get zone by given name
     * @param name : zone name
     * @return Zone with the same name
     */
    Zone getZoneByName(String name);

    List<Zone> getAllZones();
}
