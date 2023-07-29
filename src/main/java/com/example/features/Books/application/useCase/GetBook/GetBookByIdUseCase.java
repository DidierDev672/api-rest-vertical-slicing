package com.example.features.Books.application.useCase.GetBook;

import com.example.features.Books.application.dto.BookDTO;
import com.example.features.Books.domain.model.Book;

import java.util.Optional;

public interface GetBookByIdUseCase {
    Optional<Book> getBookById(Long id);
}
