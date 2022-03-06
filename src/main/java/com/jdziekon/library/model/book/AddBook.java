package com.jdziekon.library.model.book;

import com.jdziekon.library.model.author.AddAuthor;

import java.util.List;

public class AddBook {

    private String title;
    private List<AddAuthor> authorList;

    public AddBook() {
    }

    public AddBook(String title, List<AddAuthor> authorList) {
        this.title = title;
        this.authorList = authorList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<AddAuthor> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<AddAuthor> authorList) {
        this.authorList = authorList;
    }

}
