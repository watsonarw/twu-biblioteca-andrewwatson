package com.twu.biblioteca.menu;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.IOUtilities;

import java.io.BufferedReader;
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
        menuOptions.put("4", ListMoviesItem.instance);
        menuOptions.put("5", CheckOutMovieItem.instance);
        menuOptions.put("L", LoginItem.instance);
    }

    public void loop() {
            while (!BibliotecaApp.testing) {
                this.show();
                this.handleResponse();
            }
    }

    public void show() {
        StringBuilder sb = new StringBuilder();

        sb.append("------ Main Menu ------\n" +
                "Select an option below:\n");
        for (String key: menuOptions.keySet()) {
            AbstractMenuItem item = menuOptions.get(key);
            if(item.isAvailable()) {
                sb.append(" " + key + " | " + item + "\n");
            };
        }
        IOUtilities.print(sb.toString());
    }

    public void handleResponse() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String response = IOUtilities.readLine();
        if (menuOptions.containsKey(response)) {
            menuOptions.get(response).action();
        } else {
            IOUtilities.print(INVALID_INPUT_MESSAGE);
        }
    }
}
