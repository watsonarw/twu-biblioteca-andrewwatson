package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by watsonarw on 16/04/15.
 */
public class MainMenu {

    public static MainMenu instance = new MainMenu();
    private HashMap<Integer, String> menuOptions = new HashMap<Integer, String>();

    public static final String INVALID_INPUT_MESSAGE = "The input you've entered is invalid, please try again.\n";

    private MainMenu(){
        menuOptions.put(1, "List Books");
        menuOptions.put(0, "Quit");
    }

    public void show() {
        StringBuilder sb = new StringBuilder();

        sb.append("------ Main Menu ------\n" +
                "Select an option below:\n");
        for (Integer key: menuOptions.keySet()) {
            sb.append(" " + key + " | " + menuOptions.get(key) + "\n");
        }
        System.out.print(sb.toString());
    }

    public void handleResponse() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String response = br.readLine();
            switch (Integer.parseInt(response)) {
                case 1:
                    System.out.print(BibliotecaApp.getLibrary().getBookList());
                    break;
                case 0:
                    System.exit(0);
                    System.out.print("Goodbye.");
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
