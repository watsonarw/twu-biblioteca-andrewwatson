package com.twu.biblioteca.library;

/**
 * Created by watsonarw on 23/04/15.
 */
public class Movie extends AbstractLibraryProduct {

    private final String director;
    private Double rating;

    public Movie(String title, int year, String director, Double rating) {
        super(title, year);
        this.director = director;
        this.rating = rating;
    }

    public Movie(String title, int year, String director) {
        this(title, year, director, null);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(title + " (" + year + ") - " + director + ", ");
        sb.append(((rating != null) && (rating >= 1) && (rating <= 10)) ? (String.format("%.1f/10", rating)) : "unrated");
        return sb.toString();
    }
}
