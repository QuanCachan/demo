package fr.mirabeau.demo.service.internal.dao.impl;

import fr.mirabeau.demo.entity.Zone;
import fr.mirabeau.demo.service.internal.dao.ZoneDao;
import fr.mirabeau.demo.service.internal.dao.impl.dbconnection.DocumentStoreHolder;
import net.ravendb.client.documents.session.IDocumentSession;
import org.springframework.stereotype.Repository;

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
        session.store(zone);
        session.saveChanges();
        return zone;
    }
}
