package com.jdziekon.library.api;

import com.jdziekon.library.model.author.Author;
import com.jdziekon.library.service.AuthorService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/authors")
@Produces(MediaType.APPLICATION_JSON)
public class AuthorApi {

    private AuthorService authorService;

    @Inject
    public AuthorApi(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GET
    public List<Author> getAuthors() {
        return authorService.showAuthors();
    }
}
