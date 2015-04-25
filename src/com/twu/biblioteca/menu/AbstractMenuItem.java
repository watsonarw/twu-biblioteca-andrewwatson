package com.twu.biblioteca.menu;

import com.twu.biblioteca.user.Users;

/**
 * Created by watsonarw on 17/04/15.
 */
public abstract class AbstractMenuItem {

    private String name;

    protected AbstractMenuItem(String name) {
        this.name = name;
    }

    public abstract void action();

    public String toString() {
        return name;
    }

    public boolean isAvailable() {
        return (!(this instanceof LoginRequiredItem) || Users.instance.isUserLoggedIn());
    }
}
