package com.example.features.Books.domain.ports;

import com.example.features.Books.domain.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    void create(Book book);

    Optional<Book> findById(Long id);

    List<Book> findAll();

    void update(Book book);

    void delete(Long id);
}
