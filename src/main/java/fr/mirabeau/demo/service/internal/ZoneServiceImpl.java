package fr.mirabeau.demo.service.internal;

import fr.mirabeau.demo.entity.Zone;
import fr.mirabeau.demo.service.ZoneService;
import fr.mirabeau.demo.service.internal.dao.ZoneDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZoneServiceImpl implements ZoneService {
    private final ZoneDao zoneDao;
    public ZoneServiceImpl(ZoneDao zoneDao) {
        this.zoneDao = zoneDao;
    }


    @Override
    public Zone getZoneByName(String name) {
        return zoneDao.getZoneByName(name);
    }

    @Override
    public List<Zone> getAllZones() {
        return zoneDao.getAllZones();
    }


}
