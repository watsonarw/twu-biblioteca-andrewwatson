package com.twu.biblioteca.menu;

import com.twu.biblioteca.IOUtilities;
import com.twu.biblioteca.library.Library;

import java.io.IOException;

/**
 * Created by watsonarw on 17/04/15.
 */
public class CheckOutMovieItem extends AbstractCheckOutItem {

    public static AbstractMenuItem instance = new CheckOutMovieItem();

    private CheckOutMovieItem() {
        super("movie", Library.getInstance().movies);
    }

}
