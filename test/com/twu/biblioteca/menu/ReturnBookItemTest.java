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

/**
 * Created by watsonarw on 17/04/15.
 */
public class ReturnBookItemTest {

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
    public void testReturnCommandReturnsBook() {
        BibliotecaApp.getLibrary().checkoutBook(2);
        AllTests.nextInputAs("2\n");
        ReturnBookItem.instance.action();
        assertEquals(false, BibliotecaApp.getLibrary().isBookCheckedOut(2));
    }

    @Test
    public void testReturnCommandDisplaysSuccessMessageWhenSuccessful() {
        BibliotecaApp.getLibrary().checkoutBook(1);
        AllTests.nextInputAs(("1\n"));
        ReturnBookItem.instance.action();
        boolean stringContains = outStream.toString().endsWith(ReturnBookItem.SUCCESSFUL_RETURN_MESSAGE);
        assertEquals(true, stringContains);
    }

    @Test
    public void testReturnCommandDisplaysFailureMessageWhenBookAlreadyReturned() {
        AllTests.nextInputAs(("4\n"));
        ReturnBookItem.instance.action();
        outStream.reset();
        AllTests.nextInputAs(("4\n"));
        ReturnBookItem.instance.action();
        boolean stringContains = outStream.toString().endsWith(ReturnBookItem.UNSUCCESSFUL_RETURN_MESSAGE);
        assertEquals(true, stringContains);
    }


    @Test
    public void testReturnCommandDisplaysFailureMessageWhenBookDoesntExist() {
        AllTests.nextInputAs(("99\n"));
        ReturnBookItem.instance.action();
        boolean stringContains = outStream.toString().endsWith(ReturnBookItem.UNSUCCESSFUL_RETURN_MESSAGE);
        assertEquals(true, stringContains);
    }

}
