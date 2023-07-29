package com.example.features.Books.application.useCase.DeleteBook;



import com.example.features.Books.infrastructure.persistence.BookDAO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class DeleteBookUseCaseImpl implements DeleteBookUseCase {
    @Inject
    BookDAO bookDAO;

    public void deleteBook(Long id){
        bookDAO.delete(id);
    }
}
