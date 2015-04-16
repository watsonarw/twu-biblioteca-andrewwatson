package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by watsonarw on 16/04/15.
 */
public class Library {
    private ArrayList<String> books = new ArrayList<String>();


    public void addBook(String book) {
        books.add(book);
    }


    public String getBookList() {
        StringBuilder sb = new StringBuilder();
        for(String book : books) {
            sb.append(book)
                    .append("\n");
        }
        return sb.toString();
    }

}
