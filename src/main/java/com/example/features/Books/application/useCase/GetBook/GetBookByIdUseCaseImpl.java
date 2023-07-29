package com.example.features.Books.application.useCase.GetBook;

import com.example.features.Books.domain.model.Book;
import com.example.features.Books.infrastructure.persistence.BookDAO;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class GetBookByIdUseCaseImpl{
    @Inject
    BookDAO bookDAO;

    public Book getBookById(Long id){
        return bookDAO.getById(id);
    }
}
