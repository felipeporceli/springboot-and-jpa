package com.felipeporceli.application.service;

import com.felipeporceli.application.entities.Category;
import com.felipeporceli.application.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAllCategorys() {
        return repository.findAll();
    }

    public Category findCategoryById (Integer id) {
        Optional<Category> Category = repository.findById(id);
        return Category.get();
    }

}
