package fr.mirabeau.demo.service.internal;

import fr.mirabeau.demo.entity.Zone;
import fr.mirabeau.demo.service.ZoneService;
import fr.mirabeau.demo.service.internal.dao.ZoneDao;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZoneServiceImpl implements ZoneService {
    private final ZoneDao zoneDao;

    public ZoneServiceImpl(ZoneDao zoneDao) {
        this.zoneDao = zoneDao;
    }


    @Override
    public List<Zone> getZoneByName(String name) {
        return zoneDao.getZoneByName(name);
    }

    @Override
    public List<Zone> getAllZones() {
        return zoneDao.getAllZones();
    }

    @Override
    public Zone createZone(Zone zone) {
        return zoneDao.createZone(zone);
    }

    @Override
    public List<Zone> getZonesByInventoryId(String inventoryId) {
        return zoneDao.getZonesByInventoryId(inventoryId);
    }

    @Override
    public ResponseEntity<String> deleteZone(String id) {
        return zoneDao.deleteZone(id);
    }


}
