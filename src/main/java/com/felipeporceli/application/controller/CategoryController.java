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

@RestController
@RequestMapping("/Categorys")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> Categorys = service.findAllCategorys();
        return ResponseEntity.ok().body(Categorys);
    }

    @GetMapping (value = "/{id}")
    public ResponseEntity<Category> findCategoryById(@PathVariable Integer id) {
        Category obj = service.findCategoryById(id);
        return ResponseEntity.ok().body(obj);
    }

}
