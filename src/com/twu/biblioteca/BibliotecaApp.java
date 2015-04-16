package com.twu.biblioteca;

import com.twu.biblioteca.menu.MainMenu;
import org.junit.runners.AllTests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BibliotecaApp {

    private static Library library;
    private static MainMenu menu = MainMenu.instance;

    private static boolean testing = false; //Used to prevent infinite loop during unit tests

    public static void main(String[] args) {
        displayWelcomeMessage();
        setupLibrary();
        menuLoop();
    }

    public static String readLine() throws IOException {
        return new BufferedReader(new InputStreamReader(System.in)).readLine();
    }

    public static void menuLoop() {
            while (!testing) {
                menu.show();
                menu.handleResponse();
            }
    }

    private static void setupLibrary() {
        library = new Library();
        library.addBook("The Lord of The Rings", "J.R.R. Tolkien", 1954);
        library.addBook("To Kill a Mockingbird", "Harper Lee", 1960);
        library.addBook("Nineteen Eighty Four", "George Orwell", 1949);
        library.addBook("Pride and Prejudice", "Jane Austin", 1813);
        library.addBook("His Dark Materials", "Philip Pullman", 1995);
    }


    public static Library getLibrary() {
        if (library == null) {
            setupLibrary();
        }
        return library;
    }

    private static void displayWelcomeMessage() {
        print("Welcome to Biblioteca.\n");
    }

    private static void displayListOfBooks() {
        String bookList = library.getBookList();
        print(bookList);
    }

    public static void print(String str) {
        System.out.print(str);
    }

    public static void setTesting(boolean testing) {
        BibliotecaApp.testing = testing;
    }
}