package com.twu.biblioteca.user;

import com.twu.biblioteca.com.twu.biblioteca.exceptions.InvalidLibraryNumberFormatException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by watsonarw on 25/04/15.
 */
public class UserTest {

    @Test
    public void testToStringReturnsLibraryNumber() {
        User u = new User("123-4567", "Joe Citizen", "joe@email.com", "+61 412 345 678", "password");
        assertEquals("123-4567", u.toString());
    }

    @Test
    public void testGetDetailsShowsDetailsWhenAllExist() {
        User u = new User("123-4567", "Joe Citizen", "joe@email.com", "+61 412 345 678", "password");
        String expected = "User details for 123-4567\n" +
                          "Name:  Joe Citizen\n" +
                          "Email: joe@email.com\n" +
                          "Phone: +61 412 345 678\n";
        assertEquals(expected, u.getDetails());
    }

    @Test
    public void testGetDetailsShowsWhenDetailsDontAllExist() {
        User u = new User("123-4567", "", "", "", "password");
        String expected = "User details for 123-4567\n" +
                "Name:  \n" +
                "Email: \n" +
                "Phone: \n";
        assertEquals(expected, u.getDetails());
    }

    @Test(expected = InvalidLibraryNumberFormatException.class)
    public void testUserCantBeCreatedWithInvalidLibraryNumber() {
        User u = new User("123.4567", "Joe Citizen", "joe@email.com", "+61 412 345 678", "password");
        String expected = "User details for 123-4567\n" +
                "Name:  Joe Citizen\n" +
                "Email: joe@email.com\n" +
                "Phone: +61 412 345 678\n";
        assertEquals(expected, u.getDetails());
    }
}
