package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by watsonarw on 16/04/15.
 */
public class Library {
    private ArrayList<Book> books = new ArrayList<Book>();


    public void addBook(Book book) {
        books.add(book);
    }

    public void addBook(String title, String author, int year)
    {
        addBook(new Book(title, author, year));
    }


    public String getBookList() {
        StringBuilder sb = new StringBuilder();
        for(Book book : books) {
            if (!book.isCheckedOut()) {
                sb.append(" " + (books.indexOf(book) + 1) + " | ");
                sb.append(book.toString());
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public void checkoutBook(int bookId) {
        books.get(bookId-1).checkoutBook();
    }

}
