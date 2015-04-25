package com.twu.biblioteca.menu;

import com.twu.biblioteca.IOUtilities;
import com.twu.biblioteca.library.Library;

/**
 * Created by watsonarw on 17/04/15.
 */
public class CheckOutBookItem extends AbstractCheckOutItem {

    public static AbstractMenuItem instance = new CheckOutBookItem();

    private CheckOutBookItem() {
        super("book", Library.getInstance().books);
    }

}
