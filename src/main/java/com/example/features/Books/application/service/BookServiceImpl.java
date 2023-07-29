package com.example.features.Books.application.service;

import com.example.features.Books.domain.model.Book;
import com.example.features.Books.infrastructure.persistence.BookDAO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class BookServiceImpl{
    @Inject
    BookDAO bookDAO;
    public List<Book> getAllBooks(){
        return bookDAO.findAll();
    }

    public Book getBookById(Long id){
        return bookDAO.getById(id);
    }

}
