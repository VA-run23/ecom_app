package com.nie.csd.services;

import com.nie.csd.models.Products;
import com.nie.csd.repositories.ProductRepository;
import com.nie.csd.Exceptions.GeneralExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductRepository repository;

    public List<Products> getAllProducts() {
        logger.info("Fetching all products");
        return repository.findAll();
    }


    public Optional<Products> getProductById(String id) {
        logger.info("Fetching product with ID: {}", id);
        Optional<Products> product = repository.findById(id);
        if (product.isEmpty()) {
            logger.warn("Product with ID {} not found", id);
            throw new GeneralExceptions.ProductNotFoundException(id);
        }
        return product;
    }

    public Products addProduct(Products product) {
        logger.info("Adding new product: {}", product.getName());
        return repository.save(product);
    }


    public Products updateProduct(String id, Products product) {
        logger.info("Updating product with ID: {}", id);
        if (!repository.existsById(id)) {
            logger.warn("Cannot update. Product with ID {} not found", id);
            throw new GeneralExceptions.ProductNotFoundException(id);
        }
        product.setId(id);
        return repository.save(product);
    }

    
    
    public void deleteProduct(String id) {
        logger.info("Deleting product with ID: {}", id);
        if (!repository.existsById(id)) {
            logger.warn("Cannot delete. Product with ID {} not found", id);
            throw new GeneralExceptions.ProductNotFoundException(id);
        }
        repository.deleteById(id);
    }
}