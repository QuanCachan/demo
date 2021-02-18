package fr.mirabeau.demo.service.internal.dao.impl;

import fr.mirabeau.demo.entity.Zone;
import fr.mirabeau.demo.service.internal.dao.ZoneDao;
import fr.mirabeau.demo.service.internal.dao.impl.dbconnection.DocumentStoreHolder;
import net.ravendb.client.documents.session.IDocumentSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class ZoneDaoImpl implements ZoneDao {

    private static final String ZONE_ID_PREFIX = "zones/";

    @Override
    public List<Zone> getZoneByName(String name) {
        IDocumentSession session = DocumentStoreHolder.getStore().openSession();
        List<Zone> results = session.query(Zone.class)
                .whereEquals("name", name)
                .toList(); // send query
        session.close();
        return results;
    }

    @Override
    public List<Zone> getAllZones() {
        IDocumentSession session = DocumentStoreHolder.getStore().openSession();
        return session.query(Zone.class)
                .toList();
    }

    @Override
    public Zone createZone(Zone zone) {
        //TODO: check name unicity before creating new
        IDocumentSession session = DocumentStoreHolder.getStore().openSession();
        zone.setCreatedDate(LocalDateTime.now().toString());
        session.store(zone);
        if (zone.getId() != null) {
            String ravenId = zone.getId();
            String subStringId = ravenId.substring(ravenId.lastIndexOf("/") + 1);
            zone.setPublicId("Z-" + subStringId);
        }
        session.saveChanges();
        return zone;
    }

    @Override
    public Zone updateZone(Zone zone) {
        //TODO: check name unicity before creating new
        IDocumentSession session = DocumentStoreHolder.getStore().openSession();
        System.out.println("updateZone ");
        Zone result = session.query(Zone.class)
                .whereEquals("publicId", zone.getPublicId())
                .toList().get(0);
        System.out.println("result zone updated ==> " + result);
        if (result != null) {
            result.setDescription(zone.getDescription());
            result.setName(zone.getName());
            result.setRfid(zone.getRfid());
            session.saveChanges();
        }
        session.close();
        return result;
    }

    @Override
    public List<Zone> getZonesByInventoryId(String inventoryId) {
        IDocumentSession session = DocumentStoreHolder.getStore().openSession();
        List<Zone> results = session.query(Zone.class)
                .whereEquals("inventoryId", inventoryId)
                .toList(); // send query
        session.close();
        return results;
    }

    @Override
    public Zone getZoneByPublicId(String publicId) {
        IDocumentSession session = DocumentStoreHolder.getStore().openSession();
        Zone result = session.query(Zone.class)
                .whereEquals("publicId", publicId)
                .toList().get(0); // send query
        session.close();
        return result;
    }

    @Override
    public ResponseEntity<String> deleteZone(String zoneId) {
        try {
            IDocumentSession session = DocumentStoreHolder.getStore().openSession();
            session.delete("zones/" + zoneId);
            session.saveChanges();
            session.close();
            return new ResponseEntity<>("the record has been successfully deleted", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public List<Zone> deleteZoneByPublicId(String publicId) {
        IDocumentSession session = DocumentStoreHolder.getStore().openSession();
        Zone selectedZone = session.query(Zone.class)
                .whereEquals("publicId", publicId)
                .toList().get(0);
        String inventoryId = selectedZone.getLocationId();
        session.delete(selectedZone);
        session.saveChanges();
        List<Zone> result = session.query(Zone.class)
                .whereEquals("inventoryId", inventoryId)
                .toList();
        session.close();
        return result;
    }
}
