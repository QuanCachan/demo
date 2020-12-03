package fr.mirabeau.demo.service.internal.dao.impl;

import fr.mirabeau.demo.entity.Inventory;
import fr.mirabeau.demo.service.internal.dao.InventoryDao;
import fr.mirabeau.demo.service.internal.dao.impl.dbconnection.DocumentStoreHolder;
import net.ravendb.client.documents.session.IDocumentSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InventoryDaoImpl implements InventoryDao {
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
                .toList(); // send query
        return results;
    }
}
