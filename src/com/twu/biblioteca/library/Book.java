package com.twu.biblioteca.library;

/**
 * Created by watsonarw on 16/04/15.
 */
public class Book extends AbstractLibraryProduct{

    private String author;

    private boolean checkedOut = false;

    public Book(String title, String author, int year) {
        super(title, year);
        this.author = author;
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
