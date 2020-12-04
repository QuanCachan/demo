package fr.mirabeau.demo.service.internal.dao.impl;

import fr.mirabeau.demo.entity.Product;
import fr.mirabeau.demo.service.internal.dao.ProductDao;
import fr.mirabeau.demo.service.internal.dao.impl.dbconnection.DocumentStoreHolder;
import net.ravendb.client.documents.session.IDocumentSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {

    @Override
    public List<Product> getProductByName(String name) {
        IDocumentSession session = DocumentStoreHolder.getStore().openSession();
        List<Product> results = session.query(Product.class)
                .whereEquals("name", name)
                .toList(); // send query
        session.close();
        return results;
    }

    @Override
    public List<Product> getAllProducts() {
        IDocumentSession session = DocumentStoreHolder.getStore().openSession();
        return session.query(Product.class)
                .toList();
    }
}
