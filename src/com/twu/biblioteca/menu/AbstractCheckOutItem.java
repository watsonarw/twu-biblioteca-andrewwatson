package com.twu.biblioteca.menu;

import com.twu.biblioteca.IOUtilities;
import com.twu.biblioteca.library.AbstractLibraryProductList;
import com.twu.biblioteca.library.Library;

/**
 * Created by watsonarw on 24/04/15.
 */
public class AbstractCheckOutItem extends AbstractMenuItem implements LoginRequiredItem {
    public final String instruction;
    public final String successfulMessage;
    public final String unsuccessfulMessage;

    private AbstractLibraryProductList list;

    public AbstractCheckOutItem(String product, AbstractLibraryProductList list) {
        super("Checkout " + product);
        this.list = list;
        instruction = String.format("Which %s below would you like to check out:\n", product);
        successfulMessage = String.format("Thank you! Enjoy the %s\n", product);
        unsuccessfulMessage = String.format("That %s is not available.\n", product);
    }

    @Override
    public void action() {
        IOUtilities.print(instruction +
                list.getAvailableList());
        try {
            String response = IOUtilities.readLine();
            if (productAvailable(Integer.parseInt(response))) {
                list.checkOut(Integer.parseInt(response));
                IOUtilities.print(successfulMessage);
            } else {
                IOUtilities.print(unsuccessfulMessage);
            }
        } catch (NumberFormatException e2) {

        }
    }

    private boolean productAvailable(int id) {
        return list.exists(id) && !list.isCheckedOut(id);
    }
}
