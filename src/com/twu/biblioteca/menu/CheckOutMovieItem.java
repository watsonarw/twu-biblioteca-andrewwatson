package com.twu.biblioteca.menu;

import com.twu.biblioteca.IOUtilities;
import com.twu.biblioteca.library.Library;

import java.io.IOException;

/**
 * Created by watsonarw on 17/04/15.
 */
public class CheckOutMovieItem extends AbstractMenuItem{

    public static AbstractMenuItem instance = new CheckOutMovieItem();

    public static final String CHECK_OUT_INSTRUCTION = "Which movie below would you like to check out:\n";
    public static final String SUCCESSFUL_CHECKOUT_MESSAGE = "Thank you! Enjoy the movie\n";
    public static final String UNSUCCESSFUL_CHECKOUT_MESSAGE = "That movie is not available.\n";

    private CheckOutMovieItem() {
        super("Checkout Movie");
    }

    @Override
    public void action() {
        IOUtilities.print(CHECK_OUT_INSTRUCTION +
                Library.getInstance().getMovieList());
        try {
            String response = IOUtilities.readLine();
            if (movieAvailable(Integer.parseInt(response))) {
                Library.getInstance().checkoutMovie(Integer.parseInt(response));
                IOUtilities.print(SUCCESSFUL_CHECKOUT_MESSAGE);
            } else {
                IOUtilities.print(UNSUCCESSFUL_CHECKOUT_MESSAGE);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e2) {

        }
    }

    private boolean movieAvailable(int movieId) {
        return Library.getInstance().movieExists(movieId) && !Library.getInstance().isMovieCheckedOut(movieId);
    }
}
