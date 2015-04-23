package com.twu.biblioteca.menu;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.TestUtilities;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;


/**
 * Created by watsonarw on 16/04/15.
 */
public class MainMenuTest {

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
    public void testDisplayMainMenu() {
        String expected = "------ Main Menu ------\n" +
                          "Select an option below:\n" +
                          " 1 | List Books\n" +
                          " Q | Quit\n" +
                          " 2 | Checkout Book\n" +
                          " 3 | Return Book\n";

        MainMenu menu = MainMenu.instance;
        menu.show();
        assertEquals(expected, outStream.toString());
    }

    @Test
    public void testSelectionOneShowsListOfBooks() {
        String expected = BibliotecaApp.getLibrary().getBookList();
        MainMenu menu = MainMenu.instance;
        TestUtilities.nextInputAs("1\n");
        menu.handleResponse();

        assertEquals(expected, outStream.toString());
    }

    @Test
    public void testInvalidSelectionShowsInvalidMessage() {
        String expected = MainMenu.INVALID_INPUT_MESSAGE;
        MainMenu menu = MainMenu.instance;
        TestUtilities.nextInputAs("S\n");
        menu.handleResponse();

        assertEquals(expected, outStream.toString());
    }

    @Test(expected = RuntimeException.class)
    public void testSelectionQThrowsRuntimeExceptionToQuit()
    {
        MainMenu menu = MainMenu.instance;
        TestUtilities.nextInputAs("Q\n");
        menu.handleResponse();
    }


    @Test
    public void testSelection2CallsCheckOutCommand() {
        MainMenu menu = MainMenu.instance;
        TestUtilities.nextInputAs("2\n");
        menu.handleResponse();
        boolean stringContains = outStream.toString().startsWith(CheckOutBookItem.CHECK_OUT_INSTRUCTION);
        assertEquals(true, stringContains);
    }

    @Test
    public void testSelection3CallsReturnCommand() {
        MainMenu menu = MainMenu.instance;
        TestUtilities.nextInputAs("3\n");
        menu.handleResponse();
        boolean stringContains = outStream.toString().startsWith(ReturnBookItem.RETURN_INSTRUCTION);
        assertEquals(true, stringContains);
    }



}
