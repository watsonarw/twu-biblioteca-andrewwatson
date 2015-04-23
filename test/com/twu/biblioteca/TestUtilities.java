package com.twu.biblioteca;

import java.io.ByteArrayInputStream;

/**
 * Created by watsonarw on 16/04/15.
 */

public class TestUtilities {

    public static void nextInputAs(String s) {
        ByteArrayInputStream inStream = new ByteArrayInputStream(s.getBytes());
        System.setIn(inStream);
        BibliotecaApp.setTesting(false);
    }

    public static void commonTearDown() {
            System.setOut(null);
            System.setIn(System.in);
    }

}
