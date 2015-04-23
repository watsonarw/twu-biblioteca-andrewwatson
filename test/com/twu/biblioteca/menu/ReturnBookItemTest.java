package com.twu.biblioteca.menu;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.TestUtilities;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
        TestUtilities.commonTearDown();
    }

    @Test
    public void testReturnCommandReturnsBook() {
        Library.getInstance().checkoutBook(2);
        TestUtilities.nextInputAs("2\n");
        ReturnBookItem.instance.action();
        assertEquals(false, Library.getInstance().isBookCheckedOut(2));
    }

    @Test
    public void testReturnCommandDisplaysSuccessMessageWhenSuccessful() {
        Library.getInstance().checkoutBook(1);
        TestUtilities.nextInputAs(("1\n"));
        ReturnBookItem.instance.action();
        boolean stringContains = outStream.toString().endsWith(ReturnBookItem.SUCCESSFUL_RETURN_MESSAGE);
        assertEquals(true, stringContains);
    }

    @Test
    public void testReturnCommandDisplaysFailureMessageWhenBookAlreadyReturned() {
        TestUtilities.nextInputAs(("4\n"));
        ReturnBookItem.instance.action();
        outStream.reset();
        TestUtilities.nextInputAs(("4\n"));
        ReturnBookItem.instance.action();
        boolean stringContains = outStream.toString().endsWith(ReturnBookItem.UNSUCCESSFUL_RETURN_MESSAGE);
        assertEquals(true, stringContains);
    }


    @Test
    public void testReturnCommandDisplaysFailureMessageWhenBookDoesntExist() {
        TestUtilities.nextInputAs(("99\n"));
        ReturnBookItem.instance.action();
        boolean stringContains = outStream.toString().endsWith(ReturnBookItem.UNSUCCESSFUL_RETURN_MESSAGE);
        assertEquals(true, stringContains);
    }

}
