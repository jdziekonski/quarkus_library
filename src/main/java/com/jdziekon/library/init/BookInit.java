package com.jdziekon.library.init;

import com.jdziekon.library.model.author.AddAuthor;
import com.jdziekon.library.model.book.AddBook;
import com.jdziekon.library.service.BookService;

import io.quarkus.runtime.StartupEvent;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class BookInit {

    private BookService bookService;

    @Inject
    public BookInit(BookService bookService) {
        this.bookService = bookService;
    }

    public void addStartBooks(@Observes StartupEvent startupEvent) {
        AddAuthor thomas = new AddAuthor("David", "Thomas");
        AddAuthor hunt = new AddAuthor("Andrew", "Hunt");
        AddAuthor blaszczyk = new AddAuthor("Beata", "Blaszczyk");
        bookService.addBook(new AddBook("Pragmatyczny programista. Od czeladnika do mistrza. Wydanie II", List.of(thomas,hunt)));
        bookService.addBook(new AddBook("English 4 IT. Praktyczny kurs jezyka angielskiego dla specjalistow IT i nie tylko", List.of(blaszczyk)));
    }
}