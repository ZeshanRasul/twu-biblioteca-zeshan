package com.twu.biblioteca.itemlisters;

import com.twu.biblioteca.itemlisters.LibraryLister;
import com.twu.biblioteca.items.Book;
import com.twu.biblioteca.librarycreators.LibraryCreator;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

/**
 * Created by zeshanrasul on 31/12/2016.
 */
public class LibraryListerTest {

    private ByteArrayOutputStream outputStream;
    private LibraryCreator libraryCreator;
    private LibraryLister libraryLister;
    private ArrayList<Book> bookList;

    @Before
    public void beforeEach() {
        outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        libraryCreator = new LibraryCreator();
    }

    @Test
    public void bookShouldNotBeDisplayedInListIfCheckedOut() {
        libraryLister = new LibraryLister();
        bookList = libraryCreator.createBookLibrary();
        bookList.get(0).checkOut();
        libraryLister.displayBooks(bookList);
        assertThat(outputStream.toString(), not(containsString("Blink")));

    }

    @Test
    public void displayBooksShouldListTheDetailsOfAllBooksInLibrary() {
        libraryLister = new LibraryLister();
        libraryLister.displayBooks(libraryCreator.createBookLibrary());
        assertEquals("\n\nTitle                      Author                     Year                     \n" + "Blink                      Malcolm Gladwell           2005\n" + "The Alchemist              Paulo Coelho               1988\n" + "The Prince                 Niccolò Machiavelli        1532", outputStream.toString());
    }
}