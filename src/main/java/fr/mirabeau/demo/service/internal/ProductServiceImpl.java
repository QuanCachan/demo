package fr.mirabeau.demo.service.internal;

import fr.mirabeau.demo.entity.Product;
import fr.mirabeau.demo.service.ProductService;
import fr.mirabeau.demo.service.internal.dao.ProductDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }


    @Override
    public List<Product> getProductByName(String name) {
        return productDao.getProductByName(name);
    }

    @Override
    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }
}
