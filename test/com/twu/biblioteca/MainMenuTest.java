package com.twu.biblioteca;

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
        System.setOut(null);
    }

    @Test
    public void testDisplayMainMenu() {
        String expected = "------ Main Menu ------\n" +
                          "Select an option below:\n" +
                          " 1 | List Books\n";
        MainMenu menu = new MainMenu();
        menu.show();
        assertEquals(expected, outStream.toString());
    }
}
