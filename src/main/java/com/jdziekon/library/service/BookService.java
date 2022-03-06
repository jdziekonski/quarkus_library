package com.jdziekon.library.service;

import com.jdziekon.library.model.author.AddAuthor;
import com.jdziekon.library.model.book.AddBook;
import com.jdziekon.library.model.author.Author;
import com.jdziekon.library.model.book.Book;
import com.jdziekon.library.model.author.AuthorRepository;
import com.jdziekon.library.model.book.BookRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class BookService {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    @Inject
    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public List<Book> showAllBooks() {
        return bookRepository.findAll();
    }

    @Transactional
    public void addBook(AddBook addBook) {
        List<Author> authors = addBook.getAuthorList().stream()
                .map(this::addAuthor)
                .collect(toList());
        bookRepository.save(new Book(addBook.getTitle().toLowerCase(), authors));
    }

    public Optional<Author> findAuthorAdd(AddAuthor addAuthor) {
        return authorRepository.findByNameAndLastName(addAuthor.getName().toLowerCase(), addAuthor.getLastName().toLowerCase());
    }

    public Author addAuthor(AddAuthor addAuthor) {
        return findAuthorAdd(addAuthor)
                .orElseGet(() -> authorRepository.save(new Author(addAuthor.getName().toLowerCase(), addAuthor.getLastName().toLowerCase())));
    }

    public void removeBook(Long id) {
        bookRepository.deleteById(id);
    }

    public void patchId(AddBook addBook, Long id) {
        List<Author> authors = addBook.getAuthorList().stream()
                .map(this::addAuthor)
                .collect(toList());
        Book newBook = new Book(addBook.getTitle().toLowerCase(), authors);
        bookRepository.save(newBook);
        newBook.setId(id);
    }
}