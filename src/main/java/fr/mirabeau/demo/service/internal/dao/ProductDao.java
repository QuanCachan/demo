package fr.mirabeau.demo.service.internal.dao;

import fr.mirabeau.demo.entity.Product;

import java.util.List;

public interface ProductDao {
    /**
     * Get product by given name
     *
     * @param name : product name
     * @return product with the same name
     */
    List<Product> getProductByName(String name);

    /**
     * Get all Products
     *
     * @return all Products
     */
    List<Product> getAllProducts();
}
