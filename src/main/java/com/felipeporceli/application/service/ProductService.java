package com.felipeporceli.application.service;

import com.felipeporceli.application.entities.Product;
import com.felipeporceli.application.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAllProducts() {
        return repository.findAll();
    }

    public Product findProductById (Integer id) {
        Optional<Product> Product = repository.findById(id);
        return Product.get();
    }

}
