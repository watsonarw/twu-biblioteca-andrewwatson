package com.twu.biblioteca.menu;

import com.twu.biblioteca.IOUtilities;
import com.twu.biblioteca.com.twu.biblioteca.exceptions.IncorrectLoginException;
import com.twu.biblioteca.user.Users;

/**
 * Created by watsonarw on 25/04/15.
 */
public class LoginItem extends AbstractMenuItem {

    public static LoginItem instance = new LoginItem();

    public static String LOGIN_SUCCESSFUL_STRING = "Login successful.\n";
    private LoginItem() { super("Login");}

    @Override
    public void action() {
        IOUtilities.print("Please enter your library number: ");
        String libraryNumber = IOUtilities.readLine();
        IOUtilities.print("Please enter your password: ");
        String password = IOUtilities.readLine();
        try {
            Users.instance.logIn(libraryNumber, password);
            IOUtilities.print(LOGIN_SUCCESSFUL_STRING);
        } catch (IncorrectLoginException e) {
            IOUtilities.print(e.getMessage());
        }
    }
}
