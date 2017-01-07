package com.twu.biblioteca.items;

/**
 * Created by zeshanrasul on 06/01/2017.
 */
public class Movie {

    private String title;
    private int year;
    private String director;
    private int rating;
    public boolean checkedOut;

    public Movie(String t, int y, String d, int r) {
        title = t;
        year = y;
        director = d;
        rating = r;
        checkedOut = false;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public int getRating() {
        return rating;
    }


    public void checkOut() {
        checkedOut = true;
    }

    public void returnMovie() {
        checkedOut = false;
    }

    public void printDetails() {
        System.out.printf("\n" + "%-25.30s  %-25.30s  %-25.30s  %-1.30s", getTitle(), getYear(), getDirector(), getRating());
    }
}
