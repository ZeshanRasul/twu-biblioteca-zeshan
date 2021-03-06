package com.twu.biblioteca.itemlisters;

import com.twu.biblioteca.itemlisters.MovieLibraryLister;
import com.twu.biblioteca.items.Movie;
import com.twu.biblioteca.librarycreators.MovieLibraryCreator;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
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
    public void movieShouldNotBeDisplayInListIfCheckedout() {
        movieLibraryLister = new MovieLibraryLister();
        movieList = movieLibraryCreator.createMovieLibrary();
        movieList.get(0).checkOut();
        movieLibraryLister.displayMovies(movieList);
        assertThat(outputStream.toString(), not(containsString("The Godfather     1972")));
    }

    @Test
    public void displayMoviesShouldListTheDetailsOfAllMoviesInLibrary() {
        movieLibraryLister = new MovieLibraryLister();
        movieLibraryLister.displayMovies(movieLibraryCreator.createMovieLibrary());
        assertEquals("\n\nTitle                      Year                       Director                  Rating                   \n" + "The Godfather              1972                       Francis Ford Coppola       9\n" + "The Godfather: Part II     1974                       Francis Ford Coppola       10\n" + "The Godfather: Part III    1990                       Francis Ford Coppola       7", outputStream.toString());
    }
}