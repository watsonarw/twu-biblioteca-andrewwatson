package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
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
        System.setOut(null);
        System.setIn(System.in);
    }

    @Test
    public void testDisplayMainMenu() {
        String expected = "------ Main Menu ------\n" +
                          "Select an option below:\n" +
                          " 1 | List Books\n";
        MainMenu menu = MainMenu.instance;
        menu.show();
        assertEquals(expected, outStream.toString());
    }

    @Test
    public void testSelectionOneShowsListOfBooks() {
        String expected = BibliotecaApp.getLibrary().getBookList();
        MainMenu menu = MainMenu.instance;
        nextInputAs("1\n");
        menu.handleResponse();

        assertEquals(expected, outStream.toString());
    }

    private void nextInputAs(String s) {
        ByteArrayInputStream inStream = new ByteArrayInputStream(s.getBytes());
        System.setIn(inStream);
    }
}
