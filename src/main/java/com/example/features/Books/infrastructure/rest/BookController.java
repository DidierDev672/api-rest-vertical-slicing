package com.example.features.Books.infrastructure.rest;

import com.example.features.Books.application.service.BookServiceImpl;
import com.example.features.Books.application.useCase.CreateBook.CreateBookUseCaseImpl;
import com.example.features.Books.application.useCase.DeleteBook.DeleteBookUseCaseImpl;
import com.example.features.Books.application.useCase.GetBook.GetBookByIdUseCaseImpl;
import com.example.features.Books.application.useCase.UpdateBook.UpdateBookUseCaseImpl;
import com.example.features.Books.domain.model.Book;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookController {
    private  final CreateBookUseCaseImpl createBookUseCase;
    private final GetBookByIdUseCaseImpl getBookByIdUseCase;
    private final UpdateBookUseCaseImpl updateBookUseCase;
    private final DeleteBookUseCaseImpl deleteBookUseCase;
    private final BookServiceImpl bookService;

    @Inject
    public BookController(CreateBookUseCaseImpl createBookUseCase, GetBookByIdUseCaseImpl getBookByIdUseCase, UpdateBookUseCaseImpl updateBookUseCase, DeleteBookUseCaseImpl deleteBookUseCase, BookServiceImpl bookService){
        this.createBookUseCase = createBookUseCase;
        this.getBookByIdUseCase = getBookByIdUseCase;
        this.updateBookUseCase = updateBookUseCase;
        this.deleteBookUseCase = deleteBookUseCase;
        this.bookService = bookService;
    }

    @POST
    public Response createBook(Book book){
        createBookUseCase.createBook(book);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GET
    @Path("/{id}")
    public Response getBookById(@PathParam("id") Long id){
        Book book = getBookByIdUseCase.getBookById(id);
        if(book != null){
            return Response.ok(book).build();
        }else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateBook(@PathParam("id") Long id, Book book){
        Book existingBook = bookService.getBookById(id);
        if(existingBook != null){
            existingBook.setTitle(book.getTitle());
            existingBook.setAuthor(book.getAuthor());
            existingBook.setGenre(book.getGenre());
            existingBook.setDescription(book.getDescription());
            updateBookUseCase.updateBook(existingBook);
            return  Response.ok().build();
        }else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteBook(@PathParam("id") Long id){
        Book existingBook = bookService.getBookById(id);
        if(existingBook != null){
            deleteBookUseCase.deleteBook(id);
            return Response.noContent().build();
        }else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
