package com.twu.biblioteca.com.twu.biblioteca.exceptions;

import com.twu.biblioteca.user.User;

/**
 * Created by watsonarw on 25/04/15.
 */
public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(User user) {
        super("The user account for " + user.getLibraryNumber() + " already exists.");
    }
}
