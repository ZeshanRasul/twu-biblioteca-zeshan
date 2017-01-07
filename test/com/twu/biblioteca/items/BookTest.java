package com.twu.biblioteca.items;

import com.twu.biblioteca.items.Book;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Created by zeshanrasul on 30/12/2016.
 */
public class BookTest {
    private ByteArrayOutputStream outputStream;
    private Book book;

    @Before
    public void beforeEach() {
        book = new Book("Blink", "Malcolm Gladwell", 2005);
    }

    @Test
    public void getTitleShouldReturnTitle(){
        assertEquals("Blink", book.getTitle());
    }

    @Test
    public void getAuthorShouldReturnAuthor(){
        assertEquals("Malcolm Gladwell", book.getAuthor());
    }

    @Test
    public void getYearShouldReturnYear(){
        assertEquals(2005, book.getYear());
    }

    @Test
    public void checkOutMethodShouldSetCheckedOutValueToTrue() {
        book.checkOut();
        assertEquals(true, book.checkedOut);
    }

    @Test
    public void returnBookMethodShouldSetCheckedOutValueToFalse() {
        book.returnBook();
        assertEquals(false, book.checkedOut);
    }

    @Test
    public void printDetailsShouldPrintBookDetailsInColumns(){
        outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        book.printDetails();
        assertEquals("\nBlink                      Malcolm Gladwell           2005", outputStream.toString());
    }
}