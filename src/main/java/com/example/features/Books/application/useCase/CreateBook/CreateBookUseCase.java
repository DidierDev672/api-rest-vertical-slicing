package com.example.features.Books.application.useCase.CreateBook;

import com.example.features.Books.application.dto.BookDTO;
import com.example.features.Books.domain.model.Book;

public interface CreateBookUseCase {
   Book createBook(Book book);
}
