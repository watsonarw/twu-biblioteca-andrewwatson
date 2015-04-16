package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by watsonarw on 16/04/15.
 */
public class BookTest {

    @Test
    public void testBookStringHasTitleAuthorAndYear() {
        Book book = new Book("To Kill a Mockingbird", "Harper Lee", 1960);
        assertEquals("To Kill a Mockingbird - Harper Lee, 1960", book.toString());
    }

}
