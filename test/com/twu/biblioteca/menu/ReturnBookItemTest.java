package com.twu.biblioteca.menu;

import com.twu.biblioteca.TestUtilities;
import com.twu.biblioteca.library.Library;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
        TestUtilities.commonTearDown();
    }

    @Test
    public void testReturnCommandReturnsBook() {
        Library.getInstance().checkoutBook(2);
        TestUtilities.nextInputAs("2\n");
        ReturnBookItem.instance.action();
        assertFalse(Library.getInstance().isBookCheckedOut(2));
    }

    @Test
    public void testReturnCommandDisplaysSuccessMessageWhenSuccessful() {
        Library.getInstance().checkoutBook(1);
        TestUtilities.nextInputAs(("1\n"));
        ReturnBookItem.instance.action();
        boolean stringContains = outStream.toString().endsWith(ReturnBookItem.SUCCESSFUL_RETURN_MESSAGE);
        assertTrue(stringContains);
    }

    @Test
    public void testReturnCommandDisplaysFailureMessageWhenBookAlreadyReturned() {
        TestUtilities.nextInputAs(("4\n"));
        ReturnBookItem.instance.action();
        outStream.reset();
        TestUtilities.nextInputAs(("4\n"));
        ReturnBookItem.instance.action();
        boolean stringContains = outStream.toString().endsWith(ReturnBookItem.UNSUCCESSFUL_RETURN_MESSAGE);
        assertTrue(stringContains);
    }


    @Test
    public void testReturnCommandDisplaysFailureMessageWhenBookDoesntExist() {
        TestUtilities.nextInputAs(("99\n"));
        ReturnBookItem.instance.action();
        boolean stringContains = outStream.toString().endsWith(ReturnBookItem.UNSUCCESSFUL_RETURN_MESSAGE);
        assertTrue(stringContains);
    }

}
