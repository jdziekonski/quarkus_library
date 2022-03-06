package com.jdziekon.library.service;

import com.jdziekon.library.model.author.Author;
import com.jdziekon.library.model.author.AuthorRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class AuthorService {

    private AuthorRepository authorRepository;

    @Inject
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> showAuthors() {
        return authorRepository.findAll();
    }
}
