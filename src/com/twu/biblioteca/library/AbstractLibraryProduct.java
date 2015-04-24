package com.twu.biblioteca.library;

/**
 * Created by watsonarw on 24/04/15.
 */
public abstract class AbstractLibraryProduct {
    protected final String title;
    protected final int year;
    private boolean checkedOut = false;

    protected AbstractLibraryProduct(String title, int year) {
        this.title = title;
        this.year = year;
    }

    public void checkOut() {
        this.checkedOut = true;
    }

    public boolean isCheckedOut() {return checkedOut;}

    public void checkIn() { this.checkedOut = false; }
}
