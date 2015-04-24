package com.twu.biblioteca.library;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by watsonarw on 16/04/15.
 */
public class BookTest {

    @Test
    public void testBookStringHasTitleAuthorAndYear() {
        Book book = new Book("To Kill a Mockingbird", "Harper Lee", 1960);
        assertEquals("To Kill a Mockingbird - Harper Lee, 1960", book.toString());
    }

    @Test
    public void testBookCanBeCheckedOut() {
        Book book = new Book("To Kill a Mockingbird", "Harper Lee", 1960);
        book.checkOut();
        assertTrue(book.isCheckedOut());
    }

    @Test
    public void testBookCanBeReturned() {
        Book book = new Book("To Kill a Mockingbird", "Harper Lee", 1960);
        book.checkOut();
        assertTrue(book.isCheckedOut());
        book.checkIn();
        assertFalse(book.isCheckedOut());
    }

}