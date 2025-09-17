package com.nie.csd.controllers;

import com.nie.csd.models.Products;
import com.nie.csd.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// import java.util.Optional;

@RestController
@RequestMapping({"/api/products", "/products"})
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @GetMapping({"", "/"})
    public List<Products> getAllProducts() {
        logger.info("Received request: GET all products");
        return productService.getAllProducts();
    }


    @GetMapping("/{id}")
    public Products getProductById(@PathVariable String id) {
        logger.info("Received request: GET product by ID: {}", id);
        return productService.getProductById(id).get();
    }

    @PostMapping({"", "/"})
    public Products addProduct(@RequestBody Products product) {
        logger.info("Received request: POST add product: {}", product.getName());
        return productService.addProduct(product);
    }


    @PutMapping("/{id}")
    public Products updateProduct(@PathVariable String id, @RequestBody Products product) {
        logger.info("Received request: PUT update product with ID: {}", id);
        return productService.updateProduct(id, product);
    }


    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id) {
        logger.info("Received request: DELETE product with ID: {}", id);
        productService.deleteProduct(id);
    }
}
