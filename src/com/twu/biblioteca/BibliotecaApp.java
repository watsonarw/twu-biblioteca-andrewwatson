package com.twu.biblioteca;

import com.twu.biblioteca.menu.MainMenu;

public class BibliotecaApp {

    private MainMenu menu = MainMenu.instance;

    public static boolean testing = false; //Used to prevent infinite loop during unit tests

    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp();
        app.run();
    }

    private void run() {
        displayWelcomeMessage();
        menu.loop();
    }


    private void displayWelcomeMessage() {
        IOUtilities.print("Welcome to Biblioteca.\n");
    }


    public static void setTesting(boolean testing) {
        BibliotecaApp.testing = testing;
    }
}