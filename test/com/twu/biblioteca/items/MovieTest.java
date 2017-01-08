package com.twu.biblioteca.items;

import com.twu.biblioteca.items.Movie;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Created by zeshanrasul on 06/01/2017.
 */
public class MovieTest {
    private ByteArrayOutputStream outputStream;
    private Movie movie;

    @Before
    public void beforeEach() {
        movie = new Movie("The Godfather", 1972, "Francis Ford Coppola", 9);}

    @Test
    public void getTitleShouldReturnTitle() {
        assertEquals("The Godfather", movie.getTitle());
    }

    @Test
    public void getYearShouldReturnYear() {
        assertEquals(1972, movie.getYear());
    }

    @Test
    public void getDirectorShouldReturnDirector() {
        assertEquals("Francis Ford Coppola", movie.getDirector());
    }

    @Test
    public void getRatingShouldReturnRating() {
        assertEquals(9, movie.getRating());
    }

    @Test
    public void getHolderShouldReturnNoUserByDefault() {
        assertEquals(null, movie.getHolder());
    }

    @Test
    public void checkOutMethodShouldSetCheckedOutValueToTrue() {
        movie.checkOut();
        assertEquals(true, movie.checkedOut);
    }

    @Test
    public void returnBookMethodShouldSetCheckedOutValueToFalse() {
        movie.returnMovie();
        assertEquals(false, movie.checkedOut);
    }

    @Test
    public void printDetailsShouldPrintMovieDetailsInColumns() {
        outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        movie.printDetails();
        assertEquals("\nThe Godfather              1972                       Francis Ford Coppola       9", outputStream.toString());
    }
}