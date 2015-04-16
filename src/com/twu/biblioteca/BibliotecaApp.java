package com.twu.biblioteca;

public class BibliotecaApp {

    private static Library library;

    public static void main(String[] args) {
        displayWelcomeMessage();
        setupLibrary();
        displayListOfBooks();
    }

    private static void setupLibrary() {
        library = new Library();
        library.addBook("The Lord of The Rings");
        library.addBook("To Kill a Mockingbird");
        library.addBook("Nineteen Eighty Four");
        library.addBook("Pride and Prejudice");
        library.addBook("His Dark Materials");
    }


    //TODO exposed public for the purpose of unit testing, it feels weird to do this
    public static Library getLibrary() {
        if (library == null) {
            setupLibrary();
        }
        return library;
    }

    private static void displayWelcomeMessage() {
        print("Welcome to Biblioteca.\n");
    }

    private static void displayListOfBooks() {
        String bookList = library.getBookList();
        print(bookList);
    }

    private static void print(String bookList) {
        System.out.print(bookList);
    }
}