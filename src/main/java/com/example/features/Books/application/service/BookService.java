package com.example.features.Books.application.service;

import com.example.features.Books.domain.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
   List<Book> getAllBooks();
   Optional<Book> getBookById(Long id);
   Book createBook(Book book);
   void updateBook(Book book);
   void deleteBook(Long id);
}
