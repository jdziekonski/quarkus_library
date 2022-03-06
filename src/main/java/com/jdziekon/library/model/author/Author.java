package com.jdziekon.library.model.author;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @NotNull
    private String name;

    @NotEmpty
    @NotNull
    private String lastName;

    public Author() {
    }

    public Author(@NotEmpty @NotNull String name, @NotEmpty @NotNull String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public Author(AddAuthor addAuthor) {
        this.name = addAuthor.getName();
        this.lastName = addAuthor.getLastName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
