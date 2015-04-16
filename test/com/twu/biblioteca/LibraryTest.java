package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
/**
 * Created by watsonarw on 16/04/15.
 */
public class LibraryTest {


    @Test
    public void testSingleBookLibrary() {
        Library library = new Library();
        library.addBook("The Hobbit");
        assertEquals("The Hobbit\n",library.getBookList());
    }


    @Test
    public void testMultiBookLibrary() {
        Library library = new Library();
        library.addBook("The Hobbit");
        library.addBook("Catcher in the Rye");
        assertEquals("The Hobbit\nCatcher in the Rye\n",library.getBookList());
    }
}
