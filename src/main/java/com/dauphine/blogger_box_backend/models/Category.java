package com.dauphine.blogger_box_backend.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Category {
    private Long id;
    private String name;
    private List<Post> posts = new ArrayList<>();

    // Constructeurs
    public Category(UUID uuid, String technology) {
    }

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters & Setters
    public UUID getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    // Méthodes utilitaires
    public void addPost(Post post) {
        posts.add(post);
    }

    public void removePost(Post post) {
        posts.remove(post);
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}