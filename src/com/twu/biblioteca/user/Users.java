package com.twu.biblioteca.user;

import com.twu.biblioteca.com.twu.biblioteca.exceptions.IncorrectLoginException;
import com.twu.biblioteca.com.twu.biblioteca.exceptions.UserAlreadyExistsException;

import java.util.HashMap;

/**
 * Created by watsonarw on 25/04/15.
 */
public class Users {

    private final HashMap<String, User> users = new HashMap<String, User>();

    private String currentUser;

    public static final Users instance = new Users();

    public void setupUsers() {
        addUser("123-4567", "password");
        addUser("314-1593", "circle");
        addUser("382-4377", "guest");
    }

    public void addUser(String libraryNumber, String password) {
       addUser(new User(libraryNumber, password));
    }

    public void addUser(User user) {
        validateUser(user);
        users.put(user.getLibraryNumber(), user);
    }

    private void validateUser(User user) {
        if (userExists(user)) {
            throw new UserAlreadyExistsException(user);
        }
    }

    public boolean userExists(User user) {
        return userExists(user.getLibraryNumber());
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
        if (!users.get(libraryNumber).validate(password)) {
            throw new IncorrectLoginException();
        }
    }

    public String getCurrentUser() {
        return currentUser;
    }

    public boolean isUserLoggedIn() { return currentUser != null;}

    public void clearUsers() {
        users.clear();
        currentUser = null;
    }
}
