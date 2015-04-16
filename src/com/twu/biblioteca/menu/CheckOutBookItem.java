package com.twu.biblioteca.menu;

import com.twu.biblioteca.BibliotecaApp;

import java.io.IOException;

/**
 * Created by watsonarw on 17/04/15.
 */
public class CheckOutBookItem extends AbstractMenuItem{

    public static AbstractMenuItem instance = new CheckOutBookItem();

    public static final String SUCCESSFUL_CHECKOUT_MESSAGE = "Thank you! Enjoy the book\n";

    private CheckOutBookItem() {
        super("Checkout Book");
    }

    @Override
    public void action() {
        BibliotecaApp.print("Which book below would you like to check out:\n" +
                BibliotecaApp.getLibrary().getBookList());
        try {
            String response = BibliotecaApp.readLine();
            BibliotecaApp.getLibrary().checkoutBook(Integer.parseInt(response));
            BibliotecaApp.print(SUCCESSFUL_CHECKOUT_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e2) {

        }
    }
}