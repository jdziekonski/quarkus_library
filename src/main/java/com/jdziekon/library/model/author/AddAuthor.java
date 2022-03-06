package com.jdziekon.library.model.author;

public class AddAuthor {
    String name;
    String lastName;

    public AddAuthor() {
    }

    public AddAuthor(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
