package com.twu.biblioteca.library;

/**
 * Created by watsonarw on 24/04/15.
 */
public abstract class AbstractLibraryProduct {
    protected final String title;
    protected final int year;

    protected AbstractLibraryProduct(String title, int year) {
        this.title = title;
        this.year = year;
    }
}
