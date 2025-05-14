package com.dauphine.blogger_box_backend.controllers;

import com.dauphine.blogger_box_backend.models.Post;
import com.dauphine.blogger_box_backend.services.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        return ResponseEntity.ok(postService.getAll());
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Post>> getPostsByCategory(@PathVariable UUID categoryId) {
        return ResponseEntity.ok(postService.getAllByCategoryId(categoryId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable UUID id) {
        Post post = postService.getById(id);
        return post != null ? ResponseEntity.ok(post) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Post> createPost(
            @RequestParam String title,
            @RequestParam String content,
            @RequestParam UUID categoryId) {
        return ResponseEntity.ok(postService.create(title, content, categoryId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(
            @PathVariable UUID id,
            @RequestParam String title,
            @RequestParam String content) {
        Post post = postService.update(id, title, content);
        return post != null ? ResponseEntity.ok(post) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deletePost(@PathVariable UUID id) {
        boolean deleted = postService.deleteById(id);
        return deleted ? ResponseEntity.ok(true) : ResponseEntity.notFound().build();
    }
}