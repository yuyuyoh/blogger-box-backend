
package com.dauphine.blogger_box_backend.services;

import com.dauphine.blogger_box_backend.models.Category;
import com.dauphine.blogger_box_backend.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final List<Category> temporaryCategories;

    public CategoryServiceImpl() {
        temporaryCategories = new ArrayList<>();
        temporaryCategories.add(new Category(UUID.randomUUID(), "Technology"));
        temporaryCategories.add(new Category(UUID.randomUUID(), "Science"));
        temporaryCategories.add(new Category(UUID.randomUUID(), "Business"));
    }

    @Override
    public List<Category> getAll() {
        return new ArrayList<>(temporaryCategories); // Retourne une copie pour éviter les modifications externes
    }

    @Override
    public Category getById(UUID id) {
        return temporaryCategories.stream()
                .filter(category -> id.equals(category.getId()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Category create(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Category name cannot be null or empty");
        }
        Category category = new Category(UUID.randomUUID(), name);
        temporaryCategories.add(category);
        return category;
    }

    @Override
    public Category updateName(UUID id, String name) {
        Category category = getById(id);
        if (category != null) {
            category.setName(name);
        }
        return category;
    }

    @Override
    public boolean deleteById(UUID id) {
        return temporaryCategories.removeIf(category -> id.equals(category.getId()));
    }
}