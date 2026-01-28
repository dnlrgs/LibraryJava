package com.dnlrgs.library.model;


import com.dnlrgs.library.exceptions.IsAlreadyBorrowedException;

public class Book {
    private String title;
    private String author;
    private Integer id;
    private Boolean isBorrowed;

    public Book() {
    }

    public Book(String title, String author, Integer id) {
        this.title = title;
        this.author = author;
        this.id = id;
        isBorrowed = false;
    }

    public Book(String title, String author, Integer id, boolean isBorrowed) {
        this.title = title;
        this.author = author;
        this.id = id;
        this.isBorrowed = isBorrowed;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getId() {
        return id;
    }

    public Boolean getIsBorrowed() {
        return isBorrowed;
    }

    public void ToBorrowBook() {
        try {
            if (getIsBorrowed()) {
                throw new IsAlreadyBorrowedException("Book Already Has Borrowed Status!");
            }
        } catch (IsAlreadyBorrowedException e) {
            System.out.println("Error: " + e);
        }
        isBorrowed = true;
    }

    public void toAvailable() {
        try {
            if (isBorrowed == false) {
                throw new IsAlreadyBorrowedException("Book Already Has Available Status!");
            }
        } catch (IsAlreadyBorrowedException e) {
            System.out.println("Error: " + e);
        }
        isBorrowed = false;
    }
}
