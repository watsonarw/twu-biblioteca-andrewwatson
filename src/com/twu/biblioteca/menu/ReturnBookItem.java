package com.twu.biblioteca.menu;

import com.twu.biblioteca.IOUtilities;
import com.twu.biblioteca.library.Library;

import java.io.IOException;

/**
 * Created by watsonarw on 17/04/15.
 */
public class ReturnBookItem extends AbstractMenuItem{

    public static AbstractMenuItem instance = new ReturnBookItem();

    public static final String RETURN_INSTRUCTION = "Which book below would you like to return:\n";

    public static final String SUCCESSFUL_RETURN_MESSAGE = "Thank you for returning the book.\n";
    public static final String UNSUCCESSFUL_RETURN_MESSAGE = "That is not a valid book to return.\n";

    private ReturnBookItem() {
        super("Return book");
    }

    @Override
    public void action() {
        IOUtilities.print(RETURN_INSTRUCTION +
                Library.getInstance().getCheckedOutBookList());
        try {
            String response = IOUtilities.readLine();
            if (bookCheckedOut(Integer.parseInt(response))) {
                Library.getInstance().checkInBook(Integer.parseInt(response));
                IOUtilities.print(SUCCESSFUL_RETURN_MESSAGE);
            } else {
                IOUtilities.print(UNSUCCESSFUL_RETURN_MESSAGE);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e2) {

        }
    }

    private boolean bookCheckedOut(int bookId) {
        return Library.getInstance().bookExists(bookId) && Library.getInstance().isBookCheckedOut(bookId);
    }
}
