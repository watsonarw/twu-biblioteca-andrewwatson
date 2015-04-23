package com.twu.biblioteca.menu;

import com.twu.biblioteca.BibliotecaApp;
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
        BibliotecaApp.print(Library.getInstance().getBookList());
    }
}
