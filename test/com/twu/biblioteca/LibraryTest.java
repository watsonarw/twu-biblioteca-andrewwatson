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
        library.addBook("The Hobbit", "J.R.R. Tolkien", 1937);
        assertEquals("The Hobbit - J.R.R. Tolkien, 1937\n",library.getBookList());
    }


    @Test
    public void testMultiBookLibrary() {
        Library library = new Library();
        library.addBook("The Hobbit", "J.R.R. Tolkien", 1937);
        library.addBook("Catcher in the Rye", "J.D. Salinger", 1951);
        assertEquals("The Hobbit - J.R.R. Tolkien, 1937\nCatcher in the Rye - J.D. Salinger, 1951\n",library.getBookList());
    }
}
