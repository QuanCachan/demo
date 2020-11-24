package fr.mirabeau.demo.service;

import fr.mirabeau.demo.entity.Zone;

import java.util.List;

public interface ZoneService {
    /**
     * Get ZONE by given name
     * @param name : Zone name
     * @return Zone with the same name
     */
    List<Zone> getZoneByName(String name);

    List<Zone> getAllZones();
}
