package com.twu.biblioteca.com.twu.biblioteca.exceptions;

/**
 * Created by watsonarw on 25/04/15.
 */
public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String libraryNumber) {
        super("The user account for " + libraryNumber + " already exists.");
    }
}
