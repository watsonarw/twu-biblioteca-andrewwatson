package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by watsonarw on 16/04/15.
 */
public class MainMenu {

    public static MainMenu instance = new MainMenu();

    private MainMenu(){ }

    public void show() {
        System.out.print("------ Main Menu ------\n" +
                           "Select an option below:\n" +
                           " 1 | List Books\n");
    }

    public void handleResponse() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int response = br.read();
            System.out.print(BibliotecaApp.getLibrary().getBookList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
