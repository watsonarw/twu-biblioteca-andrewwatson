package com.twu.biblioteca;

/**
 * Created by watsonarw on 23/04/15.
 */
public class Movie {
    private String title;
    private int year;
    private String director;
    private Double rating;

    public Movie(String title, int year, String director, Double rating) {
        this.title = title;
        this.year = year;
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
