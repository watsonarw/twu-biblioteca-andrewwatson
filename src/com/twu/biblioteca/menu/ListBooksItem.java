package com.twu.biblioteca.menu;

import com.twu.biblioteca.IOUtilities;
import com.twu.biblioteca.Library;

/**
 * Created by watsonarw on 17/04/15.
 */
public class ListBooksItem extends AbstractMenuItem{

    public static AbstractMenuItem instance = new ListBooksItem();

    private ListBooksItem() {
        super("List Books");
    }

    @Override
    public void action() {
        IOUtilities.print(Library.getInstance().getBookList());
    }
}
