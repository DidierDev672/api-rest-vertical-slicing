package com.example.features.Books.application.dto;

import java.io.Serializable;

public class BookDTO implements Serializable {
    private Long id;
    private String title;
    private String author;
    private String genre;
    private String description;

    public BookDTO() {
    }

    public BookDTO(Long id, String title, String author, String genre, String description) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.description = description;
    }

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "id=" + id +
                ",title='" + title + '\'' +
                ",author='" + author + '\'' +
                ",genre='" + genre + '\'' +
                ",description='" + description + '\'' +
                '}';
    }
}
