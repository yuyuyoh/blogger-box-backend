package com.dauphine.blogger_box_backend.controllers;

import  com.dauphine.blogger_box_backend.models.Category;
import  com.dauphine.blogger_box_backend.services.CategoryService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/categories")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public List<Category> retrieveAllCategories() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Category retrieveCategoryById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @PostMapping
    public Category createCategory(@RequestBody String name) {
        return service.create(name);
    }

    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable UUID id, @RequestBody String name) {
        return service.updateName(id, name);
    }

    @DeleteMapping("/{id}")
    public boolean deleteCategory(@PathVariable UUID id) {
        return service.deleteById(id);
    }
}
