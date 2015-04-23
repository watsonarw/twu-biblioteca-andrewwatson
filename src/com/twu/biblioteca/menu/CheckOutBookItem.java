package com.twu.biblioteca.menu;

import com.twu.biblioteca.IOUtilities;
import com.twu.biblioteca.library.Library;

import java.io.IOException;

/**
 * Created by watsonarw on 17/04/15.
 */
public class CheckOutBookItem extends AbstractMenuItem{

    public static AbstractMenuItem instance = new CheckOutBookItem();

    public static final String CHECK_OUT_INSTRUCTION = "Which book below would you like to check out:\n";
    public static final String SUCCESSFUL_CHECKOUT_MESSAGE = "Thank you! Enjoy the book\n";
    public static final String UNSUCCESSFUL_CHECKOUT_MESSAGE = "That book is not available.\n";

    private CheckOutBookItem() {
        super("Checkout Book");
    }

    @Override
    public void action() {
        IOUtilities.print(CHECK_OUT_INSTRUCTION +
                Library.getInstance().getBookList());
        try {
            String response = IOUtilities.readLine();
            if (bookAvailable(Integer.parseInt(response))) {
                Library.getInstance().checkoutBook(Integer.parseInt(response));
                IOUtilities.print(SUCCESSFUL_CHECKOUT_MESSAGE);
            } else {
                IOUtilities.print(UNSUCCESSFUL_CHECKOUT_MESSAGE);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e2) {

        }
    }

    private boolean bookAvailable(int bookId) {
        return Library.getInstance().bookExists(bookId) && !Library.getInstance().isBookCheckedOut(bookId);
    }
}
