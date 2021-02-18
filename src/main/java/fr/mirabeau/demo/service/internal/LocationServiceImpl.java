package fr.mirabeau.demo.service.internal;

import fr.mirabeau.demo.entity.Location;
import fr.mirabeau.demo.entity.Zone;
import fr.mirabeau.demo.service.LocationService;
import fr.mirabeau.demo.service.internal.dao.LocationDao;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {
    private final LocationDao locationDao;

    public LocationServiceImpl(LocationDao locationDao) {
        this.locationDao = locationDao;
    }

    @Override
    public List<Location> getLocationByName(String name) {
        return locationDao.getLocationByName(name);
    }

    @Override
    public List<Location> getAllLocations() {
        return locationDao.getAllLocations();
    }

    @Override
    public Location createLocation(Location location) {
        return locationDao.createLocation(location);
    }

    @Override
    public ResponseEntity<String> deleteLocation(String id) {
        return locationDao.deleteLocation(id);
    }

    @Override
    public Location createLocationZone(Zone zone) {
        return locationDao.createLocationZone(zone);
    }
}
