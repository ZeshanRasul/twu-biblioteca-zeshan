package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by zeshanrasul on 31/12/2016.
 */
public class LibraryCreatorTest {

    private Book firstBook;
    private Book secondBook;
    private Book thirdBook;
    private LibraryCreator libraryCreator;

    @Before
    public void beforeEach() {
        firstBook = new Book("Blink", "Malcolm Gladwell", 2005);
        secondBook = new Book("The Alchemist", "Paulo Coelho", 1988);
        thirdBook = new Book("The Prince", "Niccolò Machiavelli", 1532);
    }

    @Test
    public void createBookLibraryShouldCreateAnArrayListContainingGivenBooks() {
        libraryCreator = new LibraryCreator();
        ArrayList<Book> testLibrary = libraryCreator.createBookLibrary();
        assertEquals(3, testLibrary.size());
    }
}