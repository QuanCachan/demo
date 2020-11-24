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
    public Inventory getInventoryByName(String name) {
        try (IDocumentSession session = DocumentStoreHolder.getStore().openSession()) {
            List<Inventory> results =  session.query(Inventory.class)
                    .whereEquals("name", name)
                    .toList(); // send query
            System.out.println("size: " + results.size());
            return results.get(0);
        } catch (Exception exception) {
            System.out.println("exception while crawling database ==> " +exception.getMessage());
        }
        return null;

    }
}
