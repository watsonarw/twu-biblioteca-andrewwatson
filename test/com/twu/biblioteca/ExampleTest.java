package com.twu.biblioteca;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ExampleTest {

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
    public void testWelcomeMessage() {
        String expected = "Welcome to Biblioteca.\n";
        BibliotecaApp.main(null);
        assertEquals(expected, outStream.toString());
    }
}
