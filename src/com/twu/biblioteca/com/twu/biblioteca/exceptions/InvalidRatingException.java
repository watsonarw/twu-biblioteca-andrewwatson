package com.twu.biblioteca.com.twu.biblioteca.exceptions;

/**
 * Created by watsonarw on 24/04/15.
 */
public class InvalidRatingException extends RuntimeException {
    public InvalidRatingException(double rating) {
        super("The rating " + rating + " is not between 1 and 10 (inclusive).");
    }
}
