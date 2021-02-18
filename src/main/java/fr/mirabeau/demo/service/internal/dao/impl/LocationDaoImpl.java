package fr.mirabeau.demo.service.internal.dao.impl;

import fr.mirabeau.demo.entity.Location;
import fr.mirabeau.demo.entity.Zone;
import fr.mirabeau.demo.service.ZoneService;
import fr.mirabeau.demo.service.internal.dao.LocationDao;
import fr.mirabeau.demo.service.internal.dao.impl.dbconnection.DocumentStoreHolder;
import net.ravendb.client.documents.session.IDocumentSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class LocationDaoImpl implements LocationDao {

    @Autowired
    private ZoneService zoneService;

    @Override
    public List<Location> getLocationByName(String name) {
        IDocumentSession session = DocumentStoreHolder.getStore().openSession();
        List<Location> results = session.query(Location.class)
                .whereEquals("name", name)
                .toList(); // send query
        session.close();
        return results;
    }

    @Override
    public List<Location> getAllLocations() {
        IDocumentSession session = DocumentStoreHolder.getStore().openSession();
        List<Location> results = session.query(Location.class)
                .toList();
        session.close();
        return results;
    }

    @Override
    public Location createLocation(Location location) {
        IDocumentSession session = DocumentStoreHolder.getStore().openSession();
        location.setCreatedDate(LocalDateTime.now().toString());
        session.store(location);
        String locationRavenId = location.getId();
        if (locationRavenId != null) {
            String subStringId = locationRavenId.substring(locationRavenId.lastIndexOf("/") + 1);
            location.setPublicId(subStringId);
        }
        session.saveChanges();
        session.close();
        return location;
    }

    @Override
    public ResponseEntity<String> deleteLocation(String id) {
        try {
            IDocumentSession session = DocumentStoreHolder.getStore().openSession();
            System.out.println("ID => " +id);

            List<Zone> zones = session.query(Zone.class)
                    .whereEquals("locationId", "locations/" +id)
                    .toList();
            for(Zone z : zones){
                session.delete(z.getId());
            }
            session.delete("locations/"+id);
            session.saveChanges();
            session.close();
            return new ResponseEntity<>("the record has been successfully deleted", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Location createLocationZone(Zone zone) {
        IDocumentSession session = DocumentStoreHolder.getStore().openSession();
        zone.setCreatedDate(LocalDateTime.now().toString());
        session.store(zone);
        String ravenId = zone.getId();
        if (ravenId != null && !ravenId.isEmpty()) {
            String subStringId = ravenId.substring(ravenId.lastIndexOf("/") + 1);
            zone.setPublicId(subStringId);
        }
        session.saveChanges();
        session.close();
        return session.load(Location.class, zone.getLocationId());
    }
}
