package com.twu.biblioteca.menu;

import com.twu.biblioteca.IOUtilities;
import com.twu.biblioteca.com.twu.biblioteca.exceptions.QuitAppException;

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
        IOUtilities.print("Goodbye.");
        throw new QuitAppException();
    }
}
