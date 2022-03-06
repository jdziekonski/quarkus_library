package com.jdziekon.library.api;

import com.jdziekon.library.model.book.AddBook;
import com.jdziekon.library.model.book.Book;
import com.jdziekon.library.model.book.BookRepository;
import com.jdziekon.library.service.BookService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookApi {

    private BookService bookService;

    @Inject
    public BookApi(BookService bookService) {
        this.bookService = bookService;
    }

    @GET
    public List<Book> getBookList() {
        return bookService.showAllBooks();
    }

    @POST
    public void addBook(AddBook addBook) {
        bookService.addBook(addBook);
    }

    @DELETE
    public void removeBook(Long id) {
        bookService.removeBook(id);
    }

    @PATCH
    @Path("/{id}")
    public AddBook changeBook(@PathParam("id") Long id, AddBook addBook) {
        bookService.removeBook(id);
        bookService.patchId(addBook, id);
        return addBook;
    }

}
