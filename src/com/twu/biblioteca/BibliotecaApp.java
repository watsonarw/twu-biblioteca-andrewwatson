package com.twu.biblioteca;

import com.twu.biblioteca.menu.MainMenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BibliotecaApp {

    private static MainMenu menu = MainMenu.instance;

    public static boolean testing = false; //Used to prevent infinite loop during unit tests

    public static void main(String[] args) {
        displayWelcomeMessage();
        menu.loop();
    }

    public static String readLine() throws IOException {
        return new BufferedReader(new InputStreamReader(System.in)).readLine();
    }


    private static void displayWelcomeMessage() {
        print("Welcome to Biblioteca.\n");
    }


    public static void print(String str) {
        System.out.print(str);
    }

    public static void setTesting(boolean testing) {
        BibliotecaApp.testing = testing;
    }
}