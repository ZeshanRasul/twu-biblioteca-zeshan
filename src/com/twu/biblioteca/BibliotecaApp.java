package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp.run();
    }

    public static void run(){
        Message.welcomeMessage();
        LibraryCreator libraryCreator = new LibraryCreator();
        LibraryLister libraryLister = new LibraryLister();
        ArrayList<Book> bookLibrary = libraryCreator.createBookLibrary();
        libraryLister.displayBooks(bookLibrary);
    }


}
