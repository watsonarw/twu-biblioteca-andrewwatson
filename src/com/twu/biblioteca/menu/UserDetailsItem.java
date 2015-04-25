package com.twu.biblioteca.menu;

import com.twu.biblioteca.IOUtilities;
import com.twu.biblioteca.user.Users;

/**
 * Created by watsonarw on 25/04/15.
 */
public class UserDetailsItem extends AbstractMenuItem implements LoginRequiredItem{

    public static UserDetailsItem instance = new UserDetailsItem();

    private UserDetailsItem() {super("User details");}

    @Override
    public void action() {
        IOUtilities.print(Users.instance.getCurrentUser().getDetails());
    }
}
