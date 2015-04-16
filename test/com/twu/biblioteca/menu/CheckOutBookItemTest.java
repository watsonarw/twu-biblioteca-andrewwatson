package com.twu.biblioteca.menu;

import com.twu.biblioteca.AllTests;
import com.twu.biblioteca.BibliotecaApp;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by watsonarw on 17/04/15.
 */
public class CheckOutBookItemTest {

    private ByteArrayOutputStream outStream = new ByteArrayOutputStream();

    @Before
    public void setupStreams() {
        System.setOut(new PrintStream(outStream));
    }

    @After
    public void tearDown() {
        AllTests.commonTearDown();
    }

    @Test
    public void testCheckoutCommandChecksOutBook() {
        AllTests.nextInputAs("1\n");
        CheckOutBookItem.instance.action();
        assertEquals(true, BibliotecaApp.getLibrary().isBookCheckedOut(1));
    }

    @Test
    public void testCheckoutCommandDisplaysSuccessMessageWhenSuccessful() {
        AllTests.nextInputAs(("2\n"));
        CheckOutBookItem.instance.action();
        boolean stringContains = outStream.toString().endsWith(CheckOutBookItem.SUCCESSFUL_CHECKOUT_MESSAGE);
        assertEquals(true, stringContains);
    }

    @Test
    public void testCheckoutCommandDisplaysFailureMessageWhenBookAlreadyCheckedOut() {
        AllTests.nextInputAs(("1\n"));
        CheckOutBookItem.instance.action();
        outStream.reset();
        AllTests.nextInputAs(("1\n"));
        CheckOutBookItem.instance.action();
        boolean stringContains = outStream.toString().endsWith(CheckOutBookItem.UNSUCCESSFUL_CHECKOUT_MESSAGE);
        assertEquals(true, stringContains);
    }


    @Test
    public void testCheckoutCommandDisplaysFailureMessageWhenBookDoesntExist() {
        AllTests.nextInputAs(("99\n"));
        CheckOutBookItem.instance.action();
        boolean stringContains = outStream.toString().endsWith(CheckOutBookItem.UNSUCCESSFUL_CHECKOUT_MESSAGE);
        assertEquals(true, stringContains);
    }

}
