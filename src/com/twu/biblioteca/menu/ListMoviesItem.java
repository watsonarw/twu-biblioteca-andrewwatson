package com.twu.biblioteca.menu;

import com.twu.biblioteca.IOUtilities;
import com.twu.biblioteca.library.Library;

/**
 * Created by watsonarw on 24/04/15.
 */
public class ListMoviesItem extends AbstractMenuItem {

    public static AbstractMenuItem instance = new ListMoviesItem();

    private ListMoviesItem() {
        super("List movies");
    }

    @Override
    public void action() {
        IOUtilities.print(Library.getInstance().getMovieList());
    }
}
