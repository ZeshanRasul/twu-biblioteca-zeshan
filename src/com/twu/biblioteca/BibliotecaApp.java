package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp.run();
    }

    public static void run(){
        Message.welcomeMessage();
        Book book = new Book("Blink", "Malcolm Gladwell", 2005);
        book.printDetails();
    }
}
