package com.example.features.Books.application.useCase.CreateBook;

import com.example.features.Books.application.dto.BookDTO;
import com.example.features.Books.domain.model.Book;
import com.example.features.Books.domain.ports.BookRepository;
import com.example.features.Books.infrastructure.mapper.BookDTOMapper;
import com.example.features.Books.infrastructure.persistence.BookDAO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CreateBookUseCaseImpl{
    @Inject
    BookDAO bookDAO;

    public void createBook(Book book){
    bookDAO.create(book);
    }

}
