package com.twu.biblioteca.menu;

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
}
