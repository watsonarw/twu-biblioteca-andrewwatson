package com.twu.biblioteca.user;

import com.twu.biblioteca.com.twu.biblioteca.exceptions.IncorrectLoginException;
import com.twu.biblioteca.com.twu.biblioteca.exceptions.InvalidLibraryNumberFormatException;
import com.twu.biblioteca.com.twu.biblioteca.exceptions.UserAlreadyExistsException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by watsonarw on 25/04/15.
 */
public class UsersTest {


    @Test
    public void testUserExistsWhenLibraryNumberInCorrectFormat() {
        Users u = new Users();
        u.addUser("123-4567", "super secure password with 223.4 bits of entropy");
        assertTrue(u.userExists("123-4567"));
    }

    @Test(expected = InvalidLibraryNumberFormatException.class)
    public void testUserAccountCreationFailsWithInvalidLibraryNumberFormat() {
        Users u = new Users();
        u.addUser("3824377", "guest");
    }

    @Test(expected = InvalidLibraryNumberFormatException.class)
    public void testUserAccountCreationFailsWithInvalidNonNumericalLibraryNumber() {
        Users u = new Users();
        u.addUser("qwerty", "qwerty");
    }

    @Test(expected = UserAlreadyExistsException.class)
    public void testUserAccountCreationFailsWhenUserExists() {
        Users u = new Users();
        u.addUser("314-1593", "circle");
        u.addUser("314-1593", "cosine");
    }

    @Test
    public void testUserCanLogInWithCorrectLibraryNumberAndPassword() throws IncorrectLoginException {
        Users u = new Users();
        u.addUser("314-1593", "circle");
        u.logIn("314-1593", "circle");
        assertEquals("314-1593", u.getCurrentUser());
    }

    @Test(expected = IncorrectLoginException.class)
    public void testLoginWithIncorrectUsernameHasException() throws IncorrectLoginException {
        Users u = new Users();
        u.logIn("314-1593", "password");
    }

    @Test(expected = IncorrectLoginException.class)
    public void testLoginWithIncorrectPasswordHasException() throws IncorrectLoginException {
        Users u = new Users();
        u.addUser("314-1593", "circle");
        u.logIn("314-1593", "square");
    }

    @Test(expected = UserAlreadyExistsException.class)
    public void testUserAccountCreationFailsWhenUserExists2() {
        Users u = new Users();
        u.addUser("314-1593", "circle");
        User u2 = new User("314-1593", "Pi", "pi@maths.com", "03 1415 9265", "circle");
        u.addUser(u2);
    }

    @Test
    public void testUserCanBeAddedByObject() {
        Users u = new Users();
        User u2 = new User("314-1593", "Pi", "pi@maths.com", "03 1415 9265", "circle");
        u.addUser(u2);
        assertTrue(u.userExists(u2));
    }
}
