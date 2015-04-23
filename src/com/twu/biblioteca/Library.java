package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by watsonarw on 16/04/15.
 */
public class Library {
    private static Library instance;
    private ArrayList<Book> books = new ArrayList<Book>();
    private ArrayList<Movie> movies = new ArrayList<Movie>();

    static void setupLibrary() {
        instance = new Library();
        instance.addBook("The Lord of The Rings", "J.R.R. Tolkien", 1954);
        instance.addBook("To Kill a Mockingbird", "Harper Lee", 1960);
        instance.addBook("Nineteen Eighty Four", "George Orwell", 1949);
        instance.addBook("Pride and Prejudice", "Jane Austin", 1813);
        instance.addBook("His Dark Materials", "Philip Pullman", 1995);
    }

    public static Library getInstance() {
        if (instance == null) {
            setupLibrary();
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
        StringBuilder sb = new StringBuilder();
        for(Book book : books) {
            if (!book.isCheckedOut()) {
                sb.append(" " + (books.indexOf(book) + 1) + " | ");
                sb.append(book.toString());
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public String getMovieList() {
        StringBuilder sb = new StringBuilder();
        for (Movie movie : movies) {
            sb.append(" " + (movies.indexOf(movie) + 1) + " | ");
            sb.append(movie.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public String getCheckedOutBookList() {
        StringBuilder sb = new StringBuilder();
        for(Book book : books) {
            if (book.isCheckedOut()) {
                sb.append(" " + (books.indexOf(book) + 1) + " | ");
                sb.append(book.toString());
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public void checkoutBook(int bookId) {
        if (bookExists(bookId)) {
            books.get(bookId - 1).checkoutBook();
        }
    }

    public boolean isBookCheckedOut(int bookId) {
        return books.get(bookId-1).isCheckedOut();
    }

    public boolean bookExists(int bookId) {
        try {
            books.get(bookId - 1);
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    public void returnBook(int bookId) {
        if (bookExists(bookId)) {
            books.get(bookId -1).returnBook();
        }
    }

}
