package com.twu.biblioteca;

import com.twu.biblioteca.AllTests;
import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.MainMenu;
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
        AllTests.commonTearDown();
    }

    @Test
    public void testDisplayMainMenu() {
        String expected = "------ Main Menu ------\n" +
                          "Select an option below:\n" +
                          " 1 | List Books\n" +
                          " 0 | Quit\n";
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
    public void testSelectionOtherThanOneShowsInvalidMessage() {
        String expected = MainMenu.INVALID_INPUT_MESSAGE;
        MainMenu menu = MainMenu.instance;
        AllTests.nextInputAs("S\n");
        menu.handleResponse();

        assertEquals(expected, outStream.toString());
    }

    @Test(expected = RuntimeException.class)
    public void testSelectionZeroThrowsRuntimeExceptionToQuit()
    {
        MainMenu menu = MainMenu.instance;
        AllTests.nextInputAs("0\n");
        menu.handleResponse();

    }

}
