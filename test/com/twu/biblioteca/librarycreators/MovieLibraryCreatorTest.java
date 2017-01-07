package com.twu.biblioteca.librarycreators;

import com.twu.biblioteca.items.Movie;
import com.twu.biblioteca.librarycreators.MovieLibraryCreator;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by zeshanrasul on 06/01/2017.
 */
public class MovieLibraryCreatorTest {

    private Movie firstMovie;
    private Movie secondMovie;
    private Movie thirdMovie;
    private MovieLibraryCreator movieLibraryCreator;

    @Before
    public void beforeEach() {
        firstMovie = new Movie("The Godfather", 1972, "Francis Ford Coppola", 9);
        secondMovie = new Movie("The Godfather: Part II", 1974, "Francis Ford Coppola", 10);
        thirdMovie = new Movie("The Godfather: Part III", 1990, "Francis Ford Coppola", 7);
    }

    @Test
    public void createMovieLibraryShouldCreateArrayListContainingGivenBooks() {
        movieLibraryCreator = new MovieLibraryCreator();
        ArrayList<Movie> testMovieLibrary = movieLibraryCreator.createMovieLibrary();
        assertEquals(3, testMovieLibrary.size());
    }
}