package com.dauphine.blogger_box_backend.models;

import java.util.UUID;

public class Post {
    private Long id;
    private String title;
    private String content;
    private Category category;

    // Constructeurs
    public Post(UUID uuid, String introductionÀSpring, String contenuSurSpring, UUID techId) {
    }

    public Post(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public UUID getCategoryId() {
        return category.getId();
    }
}
