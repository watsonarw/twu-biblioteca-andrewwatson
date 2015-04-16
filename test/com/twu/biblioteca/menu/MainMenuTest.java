package com.twu.biblioteca.menu;

import com.twu.biblioteca.AllTests;
import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.menu.MainMenu;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

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
        AllTests.commonTearDown();
    }

    @Test
    public void testDisplayMainMenu() {
        String expected = "------ Main Menu ------\n" +
                          "Select an option below:\n" +
                          " 1 | List Books\n" +
                          " Q | Quit\n" +
                          " 2 | Checkout Book\n";
        MainMenu menu = MainMenu.instance;
        menu.show();
        assertEquals(expected, outStream.toString());
    }

    @Test
    public void testSelectionOneShowsListOfBooks() {
        String expected = BibliotecaApp.getLibrary().getBookList();
        MainMenu menu = MainMenu.instance;
        AllTests.nextInputAs("1\n");
        menu.handleResponse();

        assertEquals(expected, outStream.toString());
    }

    @Test
    public void testInvalidSelectionShowsInvalidMessage() {
        String expected = MainMenu.INVALID_INPUT_MESSAGE;
        MainMenu menu = MainMenu.instance;
        AllTests.nextInputAs("S\n");
        menu.handleResponse();

        assertEquals(expected, outStream.toString());
    }

    @Test(expected = RuntimeException.class)
    public void testSelectionQThrowsRuntimeExceptionToQuit()
    {
        MainMenu menu = MainMenu.instance;
        AllTests.nextInputAs("Q\n");
        menu.handleResponse();
    }

    @Test
    public void testSelection2Option1ChecksOutBook1() {
        MainMenu menu = MainMenu.instance;
        AllTests.nextInputAs("2\n1\n");
        menu.handleResponse();
        boolean actual = BibliotecaApp.getLibrary().isBookCheckedOut(1);
        assertEquals(true, actual);
    }

}
