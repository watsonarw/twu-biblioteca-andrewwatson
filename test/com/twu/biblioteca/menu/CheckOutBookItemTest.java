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
        nextInputAs("1\n");
        CheckOutBookItem.instance.action();
        assertEquals(true, BibliotecaApp.getLibrary().isBookCheckedOut(1));
    }

    @Test
    public void testCheckoutCommandDisplaysSuccessMessageWhenSuccessful() {
        nextInputAs(("2\n"));
        CheckOutBookItem.instance.action();
        boolean stringContains = outStream.toString().endsWith(CheckOutBookItem.SUCCESSFUL_CHECKOUT_MESSAGE);
        assertEquals(true, stringContains);
    }

    @Test
    public void testCheckoutCommandDisplaysFailureMessageWhenBookAlreadyCheckedOut() {
        AllTests.nextInputAs(("1\n"));
        CheckOutBookItem.instance.action();
        outStream.reset();
        nextInputAs(("1\n"));
        CheckOutBookItem.instance.action();
        boolean stringContains = outStream.toString().endsWith(CheckOutBookItem.UNSUCCESSFUL_CHECKOUT_MESSAGE);
        assertEquals(true, stringContains);
    }



    private static void nextInputAs(String s) {
        ByteArrayInputStream inStream = new ByteArrayInputStream(s.getBytes());
        System.setIn(inStream);
        BibliotecaApp.setTesting(false);
    }
}
