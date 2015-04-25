package com.twu.biblioteca.library;

import com.twu.biblioteca.com.twu.biblioteca.exceptions.IncorrectLoginException;
import com.twu.biblioteca.user.Users;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by watsonarw on 16/04/15.
 */
public class BookTest {

    @Before
    public void setup() {
        Users.instance.clearUsers();
    }

    @After
    public void tearDown() {
        Users.instance.clearUsers();
    }

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

    @Test
    public void testCheckedOutBookHasAccountabilityForUser() throws IncorrectLoginException {
        Users.instance.addUser("123-4567", "password");
        Users.instance.logIn("123-4567", "password");
        Book book = new Book("To Kill a Mockingbird", "Harper Lee", 1960);
        book.checkOut();
        assertEquals("123-4567", book.getCheckOutBy().toString());
    }

    @Test
    public void testReturnedBookRemovesCheckOutUser() throws IncorrectLoginException{
        Users.instance.addUser("123-4567", "password");
        Users.instance.logIn("123-4567", "password");
        Book book = new Book("To Kill a Mockingbird", "Harper Lee", 1960);
        book.checkOut();
        assertEquals("123-4567", book.getCheckOutBy().toString());
        book.checkIn();
        assertNull(book.getCheckOutBy());
    }

}
