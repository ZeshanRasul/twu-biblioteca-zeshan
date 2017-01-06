package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by zeshanrasul on 06/01/2017.
 */
public class MovieLibraryCreator {

    private Movie firstMovie;
    private Movie secondMovie;
    private Movie thirdMovie;


    public ArrayList<Movie> createMovieLibrary() {
        firstMovie = new Movie("The Godfather", 1972, "Francis Ford Coppola", 9);
        secondMovie = new Movie("The Godfather: Part II", 1974, "Francis Ford Coppola", 10);
        thirdMovie = new Movie("The Godfather: Part III", 1990, "Francis Ford Coppola", 7);

        ArrayList<Movie> movieLibrary = new ArrayList<Movie>(Arrays.asList(firstMovie, secondMovie, thirdMovie));
        return movieLibrary;
    }


}
