package com.twu.biblioteca.menu;

import com.twu.biblioteca.TestUtilities;
import com.twu.biblioteca.com.twu.biblioteca.exceptions.IncorrectLoginException;
import com.twu.biblioteca.com.twu.biblioteca.exceptions.QuitAppException;
import com.twu.biblioteca.library.Library;
import com.twu.biblioteca.user.Users;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Created by watsonarw on 16/04/15.
 */
public class MainMenuTest {

    private ByteArrayOutputStream outStream = new ByteArrayOutputStream();

    @Before
    public void setup() {
        System.setOut(new PrintStream(outStream));
        Users.instance.clearUsers();
    }

    @After
    public void tearDown() {
        TestUtilities.commonTearDown();
        Users.instance.clearUsers();
    }

    @Test
    public void testDisplayMainMenuWhenLoggedIn() throws IncorrectLoginException{

        String expected = "------ Main Menu ------\n" +
                "Select an option below:\n" +
                " 1 | List books\n" +
                " 2 | Checkout book\n" +
                " 3 | Return book\n" +
                " 4 | List movies\n" +
                " 5 | Checkout movie\n" +
                " D | User details\n" +
                " L | Login\n" +
                " Q | Quit\n";

        Users.instance.addUser("123-4567", "password");
        Users.instance.logIn("123-4567", "password");

        MainMenu menu = MainMenu.instance;
        menu.show();
        assertEquals(expected, outStream.toString());
    }

    @Test
    public void testDisplayMainMenuWhenNotLoggedIn() {
        String expected = "------ Main Menu ------\n" +
                "Select an option below:\n" +
                " 1 | List books\n" +
                " 4 | List movies\n" +
                " L | Login\n" +
                " Q | Quit\n";

        MainMenu menu = MainMenu.instance;
        menu.show();
        assertEquals(expected, outStream.toString());
    }

    @Test
    public void testSelectionOneShowsListOfBooks() {
        String expected = Library.getInstance().getBookList();
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

    @Test(expected = QuitAppException.class)
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
        boolean stringContains = outStream.toString().startsWith("Which book below would you like to check out:\n");
        assertTrue(stringContains);
    }

    @Test
    public void testSelection3CallsReturnCommand() {
        MainMenu menu = MainMenu.instance;
        TestUtilities.nextInputAs("3\n");
        menu.handleResponse();
        boolean stringContains = outStream.toString().startsWith(ReturnBookItem.RETURN_INSTRUCTION);
        assertTrue(stringContains);
    }



}
