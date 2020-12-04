package fr.mirabeau.demo.controller;

import fr.mirabeau.demo.entity.Product;
import fr.mirabeau.demo.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("products")
public class ProductController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/{name}")
    public List<Product> getProductByName(@PathVariable String name) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("get a Product by name");
        }
        return productService.getProductByName(name);
    }

    @GetMapping()
    public List<Product> getAllProducts() {
        LOGGER.info("get all Products");
        return productService.getAllProducts();
    }
}
