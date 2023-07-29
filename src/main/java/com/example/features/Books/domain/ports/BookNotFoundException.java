package com.example.features.Books.domain.ports;

public class BookNotFoundException  extends RuntimeException{
    public BookNotFoundException(String message){
        super(message);
    }
}
