package com.dnlrgs.library.model;


import com.dnlrgs.library.exceptions.IsAlreadyBorrowedException;

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

    public void ToBorrowBook() {
        try {
            if (isBorrowed == true) {
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
