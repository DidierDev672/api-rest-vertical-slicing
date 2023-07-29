package com.example.features.Books.application.useCase.UpdateBook;

import com.example.features.Books.domain.model.Book;
import com.example.features.Books.domain.ports.BookRepository;
import com.example.features.Books.infrastructure.persistence.BookDAO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class UpdateBookUseCaseImpl implements UpdateBookUseCase {
    @Inject
    BookDAO bookDAO;

    public void updateBook(Book book){
        bookDAO.update(book);
    }
}
