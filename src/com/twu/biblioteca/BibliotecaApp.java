package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        displayWelcomeMessage();
        displayListOfBooks();
    }

    private static void displayWelcomeMessage() {
        System.out.println("Welcome to Biblioteca.");
    }

    private static void displayListOfBooks() {
        System.out.println( "The Lord of The Rings\n" +
                            "To Kill a Mockingbird\n" +
                            "Nineteen Eighty Four\n" +
                            "Pride and Prejudice\n" +
                            "His Dark Materials"
                        );
    }
}