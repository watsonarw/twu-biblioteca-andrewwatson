package com.twu.biblioteca.menu;

import com.twu.biblioteca.BibliotecaApp;

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
        super("Return Book");
    }

    @Override
    public void action() {
        BibliotecaApp.print(RETURN_INSTRUCTION +
                BibliotecaApp.getLibrary().getCheckedOutBookList());
        try {
            String response = BibliotecaApp.readLine();
            if (bookCheckedOut(Integer.parseInt(response))) {
                BibliotecaApp.getLibrary().returnBook(Integer.parseInt(response));
                BibliotecaApp.print(SUCCESSFUL_RETURN_MESSAGE);
            } else {
                BibliotecaApp.print(UNSUCCESSFUL_RETURN_MESSAGE);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e2) {

        }
    }

    private boolean bookCheckedOut(int bookId) {
        return BibliotecaApp.getLibrary().bookExists(bookId) && BibliotecaApp.getLibrary().isBookCheckedOut(bookId);
    }
}
