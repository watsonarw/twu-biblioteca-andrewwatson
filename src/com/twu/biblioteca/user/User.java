package com.twu.biblioteca.user;

import com.twu.biblioteca.com.twu.biblioteca.exceptions.InvalidLibraryNumberFormatException;

/**
 * Created by watsonarw on 25/04/15.
 */
public class User {
    private String libraryNumber;
    private String name = "";
    private String emailAddress = "";
    private String phoneNumber = "";
    private String password = "";

    public User(String libraryNumber, String name, String emailAddress, String phoneNumber, String password) {
        this.libraryNumber = libraryNumber;
        validateLibraryNumber();
        this.name = name;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public User(String libraryNumber, String password) {
        this(libraryNumber, "", "", "", password);
    }

    @Override
    public String toString() {
        return libraryNumber;
    }

    public String getLibraryNumber() { return this.libraryNumber; }

    private void validateLibraryNumber() {
        if (!libraryNumber.matches("^[\\d]{3}-[\\d]{4}$")) {
            throw new InvalidLibraryNumberFormatException(libraryNumber);
        }
    }

    public String getDetails() {
        return  "User details for " + libraryNumber + "\n" +
                "Name:  " + name + "\n" +
                "Email: " + emailAddress + "\n" +
                "Phone: " + phoneNumber + "\n";
    }

    public boolean validate(String password) {
        return this.password.equals(password);
    }
};
