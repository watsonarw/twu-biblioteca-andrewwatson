package com.twu.biblioteca.menu;

import com.twu.biblioteca.BibliotecaApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by watsonarw on 16/04/15.
 */
public class MainMenu {

    public static MainMenu instance = new MainMenu();
    private HashMap<String, AbstractMenuItem> menuOptions = new HashMap<String, AbstractMenuItem>();

    public static final String INVALID_INPUT_MESSAGE = "The input you've entered is invalid, please try again.\n";

    private MainMenu(){
        menuOptions.put("1", ListBooksItem.instance);
        menuOptions.put("Q", QuitItem.instance);
        menuOptions.put("2", CheckOutBookItem.instance);
        menuOptions.put("3", ReturnBookItem.instance);
    }

    public void show() {
        StringBuilder sb = new StringBuilder();

        sb.append("------ Main Menu ------\n" +
                "Select an option below:\n");
        for (String key: menuOptions.keySet()) {
            sb.append(" " + key + " | " + menuOptions.get(key) + "\n");
        }
        BibliotecaApp.print(sb.toString());
    }

    public void handleResponse() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String response = BibliotecaApp.readLine();
            if (menuOptions.containsKey(response)) {
                menuOptions.get(response).action();
            } else {
                BibliotecaApp.print(INVALID_INPUT_MESSAGE);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
