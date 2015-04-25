package com.twu.biblioteca.com.twu.biblioteca.exceptions;

/**
 * Created by watsonarw on 25/04/15.
 */
public class IncorrectLoginException extends Exception {
    public IncorrectLoginException() {
        super("The library number or password you entered was not correct. Please try again.");
    }
}