package com.twu.biblioteca.library;

import com.twu.biblioteca.user.User;
import com.twu.biblioteca.user.Users;

/**
 * Created by watsonarw on 24/04/15.
 */
public abstract class AbstractLibraryProduct {
    protected final String title;
    protected final int year;
    private boolean checkedOut = false;

    private User checkOutBy;

    protected AbstractLibraryProduct(String title, int year) {
        this.title = title;
        this.year = year;
    }

    public void checkOut() {
        this.checkedOut = true;
        checkOutBy = Users.instance.getCurrentUser();
    }

    public boolean isCheckedOut() {return checkedOut;}

    public void checkIn() {
        this.checkedOut = false;
        this.checkOutBy = null;
    }

    public User getCheckOutBy() {
        return this.checkOutBy;
    }
}
