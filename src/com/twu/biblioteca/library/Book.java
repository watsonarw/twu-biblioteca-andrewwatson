package com.twu.biblioteca.library;

/**
 * Created by watsonarw on 16/04/15.
 */
public class Book extends AbstractLibraryProduct{

    private String author;

    public Book(String title, String author, int year) {
        super(title, year);
        this.author = author;
    }

    @Override
    public String toString() {
        return title + " - " + author + ", " + year;
    }

}
