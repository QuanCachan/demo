package fr.mirabeau.demo.service;

import fr.mirabeau.demo.entity.Product;

import java.util.List;

public interface ProductService {
    /**
     * Get product by given name
     *
     * @param name : Product name
     * @return Product with the same name
     */
    List<Product> getProductByName(String name);

    /**
     * Get all Products
     *
     * @return all Products
     */
    List<Product> getAllProducts();
}
