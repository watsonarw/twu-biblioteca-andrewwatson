package com.twu.biblioteca.library;

/**
 * Created by watsonarw on 16/04/15.
 */
public class Book {

    private String title;
    private String author;
    private int year;

    private boolean checkedOut = false;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public String toString() {
        return title + " - " + author + ", " + year;
    }

    public void checkoutBook() {
        this.checkedOut = true;
    }

    public boolean isCheckedOut() {return checkedOut;}

    public void returnBook() { this.checkedOut = false; }

}
