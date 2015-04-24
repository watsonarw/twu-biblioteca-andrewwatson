package com.twu.biblioteca.library;

import java.util.ArrayList;

/**
 * Created by watsonarw on 16/04/15.
 */
public class Library {
    private static Library instance;
    public AbstractLibraryProductList<Book> books = new AbstractLibraryProductList<Book>();
    public AbstractLibraryProductList<Movie> movies = new AbstractLibraryProductList<Movie>();

    public void setup() {
        instance.addBook("The Lord of The Rings", "J.R.R. Tolkien", 1954);
        instance.addBook("To Kill a Mockingbird", "Harper Lee", 1960);
        instance.addBook("Nineteen Eighty Four", "George Orwell", 1949);
        instance.addBook("Pride and Prejudice", "Jane Austin", 1813);
        instance.addBook("His Dark Materials", "Philip Pullman", 1995);

        instance.addMovie("Titanic", 1997, "James Cameron", 7.7);
        instance.addMovie("The Godfather", 1972, "Francis Ford Coppola", 9.2);
        instance.addMovie("Schindler's List", 1993, "Steven Spielberg", 8.9);
    }

    public static Library getInstance() {
        if (instance == null) {
            instance = new Library();
            instance.setup();
        }
        return instance;
    }


    public void addBook(Book book) {
        books.add(book);
    }

    public void addBook(String title, String author, int year)
    {
        addBook(new Book(title, author, year));
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void addMovie(String title, int year, String director, double rating){
        movies.add(new Movie(title, year, director, rating));
    }


    public String getBookList() {
        return books.getAvailableList();
    }

    public String getMovieList() {
        return movies.toString();
    }

    public String getCheckedOutBookList() {
        return books.getCheckedOutList();
    }

    public void checkoutBook(int bookId) {
        books.checkOut(bookId);
    }

    public boolean isBookCheckedOut(int bookId) {
        return books.isCheckedOut(bookId);
    }

    public boolean bookExists(int bookId) {
        return books.exists(bookId);
    }

    public void checkInBook(int bookId) {
        books.checkIn(bookId);
    }

    public void checkoutMovie(int movieId) {
        movies.checkOut(movieId);
    }

    public boolean isMovieCheckedOut(int movieId) {
        return movies.isCheckedOut(movieId);
    }

    public boolean movieExists(int movieId) {
        return movies.exists(movieId);
    }


    public void checkInMovie(int movieId) {
        movies.checkIn(movieId);
    }

}
