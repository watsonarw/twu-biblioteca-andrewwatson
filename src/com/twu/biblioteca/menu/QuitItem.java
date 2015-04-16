package com.twu.biblioteca.menu;

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
        System.out.print("Goodbye.");
        throw new RuntimeException();
    }
}
