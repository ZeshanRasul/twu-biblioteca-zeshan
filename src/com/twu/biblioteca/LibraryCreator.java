package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by zeshanrasul on 31/12/2016.
 */
public class LibraryCreator {

    public ArrayList<Book> createBookLibrary() {
        Book firstBook = new Book("Blink", "Malcolm Gladwell", 2005);
        Book secondBook = new Book("The Alchemist", "Paulo Coelho", 1988);
        Book thirdBook = new Book("The Prince", "Niccolò Machiavelli", 1532);

        ArrayList<Book> bookLibrary = new ArrayList<Book>(Arrays.asList(firstBook, secondBook, thirdBook));
        return bookLibrary;
    }



}
