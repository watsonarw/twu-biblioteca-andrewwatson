package com.twu.biblioteca.library;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by watsonarw on 16/04/15.
 */
public class LibraryTest {


    @Test
    public void testSingleBookLibrary() {
        Library library = new Library();
        library.addBook("The Hobbit", "J.R.R. Tolkien", 1937);
        assertEquals(" 1 | The Hobbit - J.R.R. Tolkien, 1937\n",library.getBookList());
    }


    @Test
    public void testMultiBookLibrary() {
        Library library = new Library();
        library.addBook("The Hobbit", "J.R.R. Tolkien", 1937);
        library.addBook("Catcher in the Rye", "J.D. Salinger", 1951);
        assertEquals(" 1 | The Hobbit - J.R.R. Tolkien, 1937\n 2 | Catcher in the Rye - J.D. Salinger, 1951\n",library.getBookList());
    }

    @Test
    public void testCheckedOutBooksDontShowInLibrary() {
        Library library = new Library();
        library.addBook("The Hobbit", "J.R.R. Tolkien", 1937);
        library.addBook("Nineteen Eighty Four", "George Orwell", 1949);
        library.addBook("Catcher in the Rye", "J.D. Salinger", 1951);
        library.checkoutBook(2);
        assertEquals(" 1 | The Hobbit - J.R.R. Tolkien, 1937\n 3 | Catcher in the Rye - J.D. Salinger, 1951\n",library.getBookList());
    }

    @Test
    public void testBookCanBeCheckedOut() {
        Library library = new Library();
        library.addBook("The Hobbit", "J.R.R. Tolkien", 1937);
        library.addBook("Nineteen Eighty Four", "George Orwell", 1949);
        library.addBook("Catcher in the Rye", "J.D. Salinger", 1951);
        library.checkoutBook(2);
        assertTrue(library.isBookCheckedOut(2));
    }

    @Test
    public void testBookCanBeReturned() {
        Library library = new Library();
        library.addBook("The Hobbit", "J.R.R. Tolkien", 1937);
        library.addBook("Nineteen Eighty Four", "George Orwell", 1949);
        library.addBook("Catcher in the Rye", "J.D. Salinger", 1951);
        library.checkoutBook(2);
        assertTrue(library.isBookCheckedOut(2));
        library.checkInBook(2);
        assertFalse(library.isBookCheckedOut(2));
    }


    @Test
    public void testReturnedBooksDoShowInLibrary() {
        Library library = new Library();
        library.addBook("The Hobbit", "J.R.R. Tolkien", 1937);
        library.addBook("Nineteen Eighty Four", "George Orwell", 1949);
        library.addBook("Catcher in the Rye", "J.D. Salinger", 1951);
        library.checkoutBook(2);
        assertEquals(" 1 | The Hobbit - J.R.R. Tolkien, 1937\n 3 | Catcher in the Rye - J.D. Salinger, 1951\n", library.getBookList());
        library.checkInBook(2);
        assertEquals(" 1 | The Hobbit - J.R.R. Tolkien, 1937\n 2 | Nineteen Eighty Four - George Orwell, 1949\n 3 | Catcher in the Rye - J.D. Salinger, 1951\n", library.getBookList());
    }

    @Test
    public void testCheckedOutBooksDoShowInCheckedOutList() {
        Library library = new Library();
        library.addBook("The Hobbit", "J.R.R. Tolkien", 1937);
        library.addBook("Nineteen Eighty Four", "George Orwell", 1949);
        library.addBook("Catcher in the Rye", "J.D. Salinger", 1951);
        library.checkoutBook(2);
        library.checkoutBook(3);
        assertEquals(" 2 | Nineteen Eighty Four - George Orwell, 1949. Currently checked out by: null\n" +
                     " 3 | Catcher in the Rye - J.D. Salinger, 1951. Currently checked out by: null\n", library.getCheckedOutBookList());
    }

    @Test
    public void testReturnedBooksDontShowInCheckedOutList() {
        Library library = new Library();
        library.addBook("The Hobbit", "J.R.R. Tolkien", 1937);
        library.addBook("Nineteen Eighty Four", "George Orwell", 1949);
        library.addBook("Catcher in the Rye", "J.D. Salinger", 1951);
        library.checkoutBook(2);
        library.checkoutBook(3);
        library.checkInBook(2);
        assertEquals(" 3 | Catcher in the Rye - J.D. Salinger, 1951. Currently checked out by: null\n", library.getCheckedOutBookList());
    }

    @Test
    public void testSingleMovieLibrary() {
        Library library = new Library();
        library.addMovie("The Godfather", 1972, "Francis Ford Coppola", 9.2);
        assertEquals(" 1 | The Godfather (1972) - Francis Ford Coppola, 9.2/10\n",library.getMovieList());
    }

    @Test
    public void testMultiMovieLibrary() {
        Library library = new Library();
        library.addMovie("The Godfather", 1972, "Francis Ford Coppola", 9.2);
        library.addMovie("Schindler's List", 1993, "Steven Spielberg", 8.9);
        assertEquals(" 1 | The Godfather (1972) - Francis Ford Coppola, 9.2/10\n" +
                " 2 | Schindler's List (1993) - Steven Spielberg, 8.9/10\n", library.getMovieList());
    }

    @Test
    public void testMovieCanBeCheckedOut() {
        Library library = new Library();
        library.addMovie("The Godfather", 1972, "Francis Ford Coppola", 9.2);
        library.addMovie("Schindler's List", 1993, "Steven Spielberg", 8.9);
        library.checkoutMovie(2);
        assertTrue(library.isMovieCheckedOut(2));
    }

    @Test
    public void testMovieCanBeReturned() {
        Library library = new Library();
        library.addMovie("The Godfather", 1972, "Francis Ford Coppola", 9.2);
        library.addMovie("Schindler's List", 1993, "Steven Spielberg", 8.9);
        library.checkoutMovie(2);
        assertTrue(library.isMovieCheckedOut(2));
        library.checkInMovie(2);
        assertFalse(library.isMovieCheckedOut(2));
    }

}
