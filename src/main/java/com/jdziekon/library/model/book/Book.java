package com.jdziekon.library.model.book;

import com.jdziekon.library.model.author.Author;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @NotEmpty
    private String title;

    @ManyToMany
    private List<Author> authorList = new ArrayList<>();

    public Book() {
    }

    public Book(@NotNull @NotEmpty String title, List<Author> authorList) {
        this.title = title;
        this.authorList = authorList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
