package com.twu.biblioteca.com.twu.biblioteca.exceptions;

/**
 * Created by watsonarw on 25/04/15.
 */
public class InvalidLibraryNumberFormatException extends RuntimeException {

    public InvalidLibraryNumberFormatException(String libraryNumber) {
        super("The library number " + libraryNumber + " does not match the format \"xxx-xxxx\".");
    }
}
