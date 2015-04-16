package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by watsonarw on 16/04/15.
 */
public class MainMenu {

    public static MainMenu instance = new MainMenu();

    public static final String INVALID_INPUT_MESSAGE = "The input you've entered is invalid, please try again.\n";

    private MainMenu(){ }

    public void show() {
        System.out.print("------ Main Menu ------\n" +
                           "Select an option below:\n" +
                           " 1 | List Books\n");
    }

    public void handleResponse() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String response = br.readLine();
            switch (Integer.parseInt(response)) {
                case 1:
                    System.out.print(BibliotecaApp.getLibrary().getBookList());
                    break;
                default:
                    System.out.print(INVALID_INPUT_MESSAGE);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.print(INVALID_INPUT_MESSAGE);
        }
    }
}
