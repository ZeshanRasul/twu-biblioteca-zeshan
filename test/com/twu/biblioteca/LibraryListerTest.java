package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Created by zeshanrasul on 31/12/2016.
 */
public class LibraryListerTest {

    private ByteArrayOutputStream outputStream;
    private LibraryCreator libraryCreator;
    private LibraryLister libraryLister;

    @Before
    public void beforeEach() {
        outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        libraryCreator = new LibraryCreator();
    }


    @Test
    public void displayBooksShouldListTheDetailsOfAllBooksInLibrary() {
        libraryLister = new LibraryLister();
        libraryLister.displayBooks(libraryCreator.createBookLibrary());
        assertEquals("\n\nTitle                      Author                     Year                     \n" + "Blink                      Malcolm Gladwell           2005                     \n" + "The Alchemist              Paulo Coelho               1988                     \n" + "The Prince                 Niccolò Machiavelli        1532                     ", outputStream.toString());
    }
}