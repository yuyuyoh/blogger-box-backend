package com.dauphine.blogger_box_backend.models;

import jakarta.persistence.*;


import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "categoryuuid")
public class Category {
    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "titre")
    private String title;
    @Column(name = "content")
    private String content;
    @Column(name = "created_date")
    private LocalDateTime createdDate;
    @Column(name = "id")

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    // Constructors
    public Category() {
        // JPA requires a no-arg constructor
    }

    public Category(String name) {
        this.name = name;
    }

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters & Setters
    public Long getId() {
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

    // Utility methods
    public void addPost(Post post) {
        posts.add(post);
        post.setCategory(this);
    }

    public void removePost(Post post) {
        posts.remove(post);
        post.setCategory(null);
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}}