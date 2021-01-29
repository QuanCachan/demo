package fr.mirabeau.demo.service.internal.dao.impl;

import fr.mirabeau.demo.entity.Inventory;
import fr.mirabeau.demo.entity.Zone;
import fr.mirabeau.demo.service.ZoneService;
import fr.mirabeau.demo.service.internal.dao.InventoryDao;
import fr.mirabeau.demo.service.internal.dao.impl.dbconnection.DocumentStoreHolder;
import net.ravendb.client.documents.session.IDocumentSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class InventoryDaoImpl implements InventoryDao {

    @Autowired
    private ZoneService zoneService;

    @Override
    public List<Inventory> getInventoryByName(String name) {
        IDocumentSession session = DocumentStoreHolder.getStore().openSession();
        List<Inventory> results = session.query(Inventory.class)
                .whereEquals("name", name)
                .toList(); // send query
        session.close();
        return results;
    }

    @Override
    public List<Inventory> getAllInventories() {
        IDocumentSession session = DocumentStoreHolder.getStore().openSession();
        List<Inventory> results = session.query(Inventory.class)
                .toList();
        session.close();
        return results;
    }

    @Override
    public Inventory createInventory(Inventory inventory) {
        IDocumentSession session = DocumentStoreHolder.getStore().openSession();
        inventory.setCreatedDate(LocalDateTime.now().toString());
        session.store(inventory);
        session.saveChanges();
        session.close();
        return inventory;
    }

    @Override
    public ResponseEntity<String> deleteInventory(String id) {
        try {
            IDocumentSession session = DocumentStoreHolder.getStore().openSession();
            System.out.println("ID => " +id);

            List<Zone> zones = session.query(Zone.class)
                    .whereEquals("inventoryId", "inventories/" +id)
                    .toList();
            for(Zone z : zones){
                session.delete(z.getId());
            }
            session.delete("inventories/"+id);
            session.saveChanges();
            session.close();
            return new ResponseEntity<>("the record has been successfully deleted", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Inventory createInventoryZone(Zone zone) {
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
        return session.load(Inventory.class, zone.getInventoryId());
    }
}
