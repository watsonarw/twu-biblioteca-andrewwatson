package com.twu.biblioteca;

import com.twu.biblioteca.menu.CheckOutBookItem;
import com.twu.biblioteca.menu.CheckOutBookItemTest;
import com.twu.biblioteca.menu.MainMenuTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import java.io.ByteArrayInputStream;

/**
 * Created by watsonarw on 16/04/15.
 */

@RunWith(Suite.class)

@Suite.SuiteClasses({
        BibliotecaAppTest.class,
        LibraryTest.class,
        BookTest.class,
        MainMenuTest.class,
        CheckOutBookItemTest.class
})
public class AllTests {

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
