package com.twu.biblioteca.menu;

import com.twu.biblioteca.TestUtilities;
import com.twu.biblioteca.library.Library;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;

/**
 * Created by watsonarw on 17/04/15.
 */
public class CheckOutMovieItemTest {

    private ByteArrayOutputStream outStream = new ByteArrayOutputStream();

    @Before
    public void setupStreams() {
        System.setOut(new PrintStream(outStream));
    }

    @After
    public void tearDown() {
        TestUtilities.commonTearDown();
    }

    @Test
    public void testCheckoutCommandChecksOutMovie() {
        TestUtilities.nextInputAs("1\n");
        CheckOutMovieItem.instance.action();
        assertTrue(Library.getInstance().isMovieCheckedOut(1));
    }

    @Test
    public void testCheckoutCommandDisplaysSuccessMessageWhenSuccessful() {
        TestUtilities.nextInputAs(("2\n"));
        CheckOutMovieItem.instance.action();
        boolean stringContains = outStream.toString().endsWith(CheckOutMovieItem.SUCCESSFUL_CHECKOUT_MESSAGE);
        assertTrue(stringContains);
    }

    @Test
    public void testCheckoutCommandDisplaysFailureMessageWhenMovieAlreadyCheckedOut() {
        TestUtilities.nextInputAs(("1\n"));
        CheckOutMovieItem.instance.action();
        outStream.reset();
        TestUtilities.nextInputAs(("1\n"));
        CheckOutMovieItem.instance.action();
        boolean stringContains = outStream.toString().endsWith(CheckOutMovieItem.UNSUCCESSFUL_CHECKOUT_MESSAGE);
        assertTrue(stringContains);
    }


    @Test
    public void testCheckoutCommandDisplaysFailureMessageWhenMovieDoesntExist() {
        TestUtilities.nextInputAs(("99\n"));
        CheckOutMovieItem.instance.action();
        boolean stringContains = outStream.toString().endsWith(CheckOutMovieItem.UNSUCCESSFUL_CHECKOUT_MESSAGE);
        assertTrue(stringContains);
    }

}
