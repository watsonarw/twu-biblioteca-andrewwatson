package com.twu.biblioteca;

/**
 * Created by watsonarw on 16/04/15.
 */
public class Book {

    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public String toString() {
        return title + " - " + author + ", " + year;
    }

}
