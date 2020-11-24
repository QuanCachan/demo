package fr.mirabeau.demo.service.internal.dao.impl;

import fr.mirabeau.demo.entity.Inventory;
import fr.mirabeau.demo.entity.Zone;
import fr.mirabeau.demo.service.internal.dao.ZoneDao;
import fr.mirabeau.demo.service.internal.dao.impl.dbconnection.DocumentStoreHolder;
import net.ravendb.client.documents.session.IDocumentSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ZoneDaoImpl implements ZoneDao {
    @Override
    public Zone getZoneByName(String name) {
        try (IDocumentSession session = DocumentStoreHolder.getStore().openSession()) {
            List<Zone> results = (List<Zone>) session.query(Zone.class)
                    .whereEquals("name", name)
                    .toList(); // send query
            System.out.println("size: " + results.size());
            if(results == null || results.isEmpty()) return null;
            return results.get(0);
        } catch (Exception exception) {
            System.out.println("exception while crawling database ==> " + exception.getMessage());
        }
        return null;
    }

    @Override
    public List<Zone> getAllZones() {
        try (IDocumentSession session = DocumentStoreHolder.getStore().openSession()) {
            List<Zone> results = (List<Zone>) session.query(Zone.class)
                    .toList(); // send query
            System.out.println("results.size : " + results.size());
            return results;
        } catch (Exception exception) {
            System.out.println("exception while crawling database ==> " + exception.getMessage());
        }
        return null;
    }
}
