/* PT-BR Classe para manipular e lidar com requisições web relacionadas a entidade "User" */
/* EN:US Class for manipulating and handling web requests related to the "User" entity. */
package com.felipeporceli.application.controller;

import com.felipeporceli.application.entities.Category;
import com.felipeporceli.application.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/* PT-BR: Define que esta classe é um controlador REST, responsável por tratar requisições HTTP no caminho "/categories".
   EN-US: Defines this class as a REST controller, responsible for handling HTTP requests at "/categories". */

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService service;

    /* PT:BR Metodo para consultar todas as categorias
       EN:US Method for querying all categories */
    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> categories = service.findAllCategorys();
        return ResponseEntity.ok().body(categories);
    }

    /* PT:BR Metodo para consultar as categorias por id
       EN:US Method for querying categories by ID. */
    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findCategoryById(@PathVariable Integer id) {
        Category obj = service.findCategoryById(id);
        return ResponseEntity.ok().body(obj);
    }
}

