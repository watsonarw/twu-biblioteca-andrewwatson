package com.twu.biblioteca.library;

import com.twu.biblioteca.com.twu.biblioteca.exceptions.InvalidRatingException;

/**
 * Created by watsonarw on 23/04/15.
 */
public class Movie extends AbstractLibraryProduct {

    private final String director;
    private Double rating;

    public Movie(String title, int year, String director, Double rating) {
        super(title, year);
        this.director = director;
        if (rating != null && (rating < 1.0 || rating > 10.0)) throw new InvalidRatingException(rating);
        this.rating = rating;
    }

    public Movie(String title, int year, String director) {
        this(title, year, director, null);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(title + " (" + year + ") - " + director + ", ");
        sb.append((rating != null) ? (String.format("%.1f/10", rating)) : "unrated");
        return sb.toString();
    }
}
