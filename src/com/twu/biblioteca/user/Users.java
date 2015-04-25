package com.twu.biblioteca.user;

import com.twu.biblioteca.com.twu.biblioteca.exceptions.IncorrectLoginException;
import com.twu.biblioteca.com.twu.biblioteca.exceptions.InvalidLibraryNumberFormatException;
import com.twu.biblioteca.com.twu.biblioteca.exceptions.UserAlreadyExistsException;

import java.util.HashMap;

/**
 * Created by watsonarw on 25/04/15.
 */
public class Users {

    private final HashMap<String, String> users = new HashMap<String, String>();

    private String currentUser;

    public static final Users instance = new Users();

    public void setupUsers() {
        addUser("123-4567", "password");
        addUser("314-1593", "circle");
        addUser("382-4377", "guest");
    }

    public void addUser(String libraryNumber, String password)
    {
       validateLibraryNumber(libraryNumber);
       users.put(libraryNumber, password);

    }

    private void validateLibraryNumber(String libraryNumber) {
        if (!libraryNumber.matches("^[\\d]{3}-[\\d]{4}$")) {
            throw new InvalidLibraryNumberFormatException(libraryNumber);
        }
        if (userExists(libraryNumber)) {
            throw new UserAlreadyExistsException(libraryNumber);
        }

    }

    public boolean userExists(String libraryNumber) {
        return users.containsKey(libraryNumber);
    }

    public void logIn(String libraryNumber, String password) throws IncorrectLoginException{
        validateLogin(libraryNumber, password);
        currentUser = libraryNumber;
    }

    private void validateLogin(String libraryNumber, String password) throws IncorrectLoginException {
        if (!userExists(libraryNumber)) {
            throw new IncorrectLoginException();
        }
        if (!users.get(libraryNumber).equals(password)) {
            throw new IncorrectLoginException();
        }
    }

    public String getCurrentUser() {
        return currentUser == null ? "No user logged in" : currentUser;
    }

    public boolean isUserLoggedIn() { return currentUser != null;}

    public void clearUsers() {
        users.clear();
    }
}
