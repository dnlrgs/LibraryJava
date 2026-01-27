package com.dnlrgs.library.model;

public class Book {
    private String title;
    private String author;
    private Integer ID;
    private Boolean isBorrowed = false;

    public Book(String title, String author, Integer ID, Boolean isBorrowed) {
        this.title = title;
        this.author = author;
        this.ID = ID;
        this.isBorrowed = isBorrowed;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getID() {
        return ID;
    }

    public Boolean getBorrowed() {
        return isBorrowed;
    }

    public void borrowBook () {
        isBorrowed = true;
    }

    public void available () {
        isBorrowed = false;
    }
}
