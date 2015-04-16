package com.twu.biblioteca.menu;

import com.twu.biblioteca.BibliotecaApp;

/**
 * Created by watsonarw on 17/04/15.
 */
public class QuitItem extends AbstractMenuItem{

    public static AbstractMenuItem instance = new QuitItem();

    private QuitItem() {
        super("Quit");
    }

    @Override
    public void action() {
        BibliotecaApp.print("Goodbye.");
        throw new RuntimeException();
    }
}
