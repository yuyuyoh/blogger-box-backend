package com.dauphine.blogger_box_backend.services;

import com.dauphine.blogger_box_backend.models.Category;
import com.dauphine.blogger_box_backend.models.Post;
import com.dauphine.blogger_box_backend.services.CategoryService;
import com.dauphine.blogger_box_backend.services.PostService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private final List<Post> posts;
    private final CategoryService categoryService;

    public PostServiceImpl(CategoryService categoryService) {
        this.categoryService = categoryService;
        this.posts = new ArrayList<>();
        initializeDemoData();
    }

    private void initializeDemoData() {
        UUID techId = categoryService.getAll().get(0).getId();
        UUID scienceId = categoryService.getAll().get(1).getId();

        posts.add(new Post(UUID.randomUUID(), "Introduction à Spring", "Contenu sur Spring", techId));
        posts.add(new Post(UUID.randomUUID(), "Les nouveautés Java 21", "Contenu sur Java 21", techId));
        posts.add(new Post(UUID.randomUUID(), "Découverte des IA", "Contenu sur l'IA", scienceId));
    }

    @Override
    public List<Post> getAll() {
        return new ArrayList<>(posts);
    }

    @Override
    public List<Post> getAllByCategoryId(UUID categoryId) {
        return posts.stream()
                .filter(post -> categoryId.equals(post.getCategoryId()))
                .collect(Collectors.toList());
    }

    @Override
    public Post getById(UUID id) {
        return posts.stream()
                .filter(post -> id.equals(post.getId()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Post create(String title, String content, UUID categoryId) {
        if (categoryService.getById(categoryId) == null) {
            throw new IllegalArgumentException("Category not found");
        }
        Post post = new Post(UUID.randomUUID(), title, content, categoryId);
        posts.add(post);
        return post;
    }

    @Override
    public Post update(UUID id, String title, String content) {
        Post post = getById(id);
        if (post != null) {
            post.setTitle(title);
            post.setContent(content);
        }
        return post;
    }

    @Override
    public boolean deleteById(UUID id) {
        return posts.removeIf(post -> id.equals(post.getId()));
    }
}