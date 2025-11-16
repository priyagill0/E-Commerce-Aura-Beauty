package com.example.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.backend.model.Product;
import com.example.backend.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product addProduct(Product product) {
        return repo.save(product);
    }
}
