package com.twu.biblioteca;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {

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
    public void testWelcomeMessageOnFirstLine() {
        String expected = "Welcome to Biblioteca.";

        TestUtilities.nextInputAs("1\n\n");
        BibliotecaApp.setTesting(true);
        BibliotecaApp.main(null);
        String output = outStream.toString();
        int lineLength = output.indexOf("\n");
        assertEquals(expected, output.substring(0, lineLength));
    }

}
