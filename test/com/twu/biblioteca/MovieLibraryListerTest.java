package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by zeshanrasul on 06/01/2017.
 */
public class MovieLibraryListerTest {

    private ByteArrayOutputStream outputStream;
    private MovieLibraryCreator movieLibraryCreator;
    private MovieLibraryLister movieLibraryLister;
    private ArrayList<Movie> movieList;

    @Before
    public void beforeEach() {
        outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        movieLibraryCreator = new MovieLibraryCreator();
    }

    @Test
    public void displayMoviesShouldListTheDetailsOfAllMoviesInLibrary() {
        movieLibraryLister = new MovieLibraryLister();
        movieLibraryLister.displayMovies(movieLibraryCreator.createMovieLibrary());
        assertEquals("\n\nTitle                      Year                       Director                  Rating                   \n" + "The Godfather              1972                       Francis Ford Coppola       9\n" + "The Godfather: Part II     1974                       Francis Ford Coppola       10\n" + "The Godfather: Part III    1990                       Francis Ford Coppola       7", outputStream.toString());
    }
}