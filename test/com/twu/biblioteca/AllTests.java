package com.twu.biblioteca;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by watsonarw on 16/04/15.
 */

@RunWith(Suite.class)

@Suite.SuiteClasses({
        BibliotecaAppTest.class,
        LibraryTest.class,
        BookTest.class
})
public class AllTests {

}
