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
        session.saveChanges();
        return zone;
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
    public ResponseEntity<String> deleteZone(String id) {
        try {
            IDocumentSession session = DocumentStoreHolder.getStore().openSession();
            session.delete("zones/"+id);
            session.saveChanges();
            session.close();
            return new ResponseEntity<>("the record has been successfully deleted", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
