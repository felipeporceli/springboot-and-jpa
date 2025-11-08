/* PT-BR Classe para manipular e lidar com requisições web relacionadas a entidade "User" */
/* EN:US Class for manipulating and handling web requests related to the "User" entity. */
package com.felipeporceli.application.controller;

import com.felipeporceli.application.entities.Product;
import com.felipeporceli.application.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> Products = service.findAllProducts();
        return ResponseEntity.ok().body(Products);
    }

    @GetMapping (value = "/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable Integer id) {
        Product obj = service.findProductById(id);
        return ResponseEntity.ok().body(obj);
    }

}
