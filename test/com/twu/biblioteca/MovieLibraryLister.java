package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by zeshanrasul on 06/01/2017.
 */
public class MovieLibraryLister {

    public void displayMovies(ArrayList<Movie> movieList) {
        System.out.printf("\n" + "\n" +  "%-25.30s  %-25.30s  %-25.30s %-25.30s", "Title", "Year", "Director", "Rating");
        for(Movie m : movieList) {
            if (!m.checkedOut) {
                m.printDetails();
            }
        }
    }

}
