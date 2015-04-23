package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by watsonarw on 23/04/15.
 */
public class IOUtilities {

    public static String readLine() throws IOException {
        return new BufferedReader(new InputStreamReader(System.in)).readLine();
    }

    public static void print(String str) {
        System.out.print(str);
    }
}
