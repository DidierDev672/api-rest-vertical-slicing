package com.example.features.Books.infrastructure.mapper;

import com.example.features.Books.application.dto.BookDTO;
import com.example.features.Books.domain.model.Book;

public class BookDTOMapper {
    private BookDTOMapper(){

    }

    public static BookDTO toDTO(Book book){
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setAuthor(book.getAuthor());
        bookDTO.setGenre(book.getGenre());
        bookDTO.setDescription(book.getDescription());
        return bookDTO;
    }
    public static Book toEntity(BookDTO bookDTO){
        Book book = new Book();
        book.setId(bookDTO.getId());
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setGenre(bookDTO.getGenre());
        book.setDescription(bookDTO.getDescription());
        return book;
    }
}
