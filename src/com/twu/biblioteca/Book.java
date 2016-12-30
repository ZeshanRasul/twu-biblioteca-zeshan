package com.twu.biblioteca;

/**
 * Created by zeshanrasul on 30/12/2016.
 */
public class Book {

    private String title;
    private String author;
    private int year;

    public Book(String t, String a, int y) {
        title = t;
        author = a;
        year = y;
    }

    public String getTitle() {
        return title;
    }


    public String getAuthor() {
        return author;
    }


    public int getYear() {
        return year;
    }


    public void printDetails() {
        System.out.printf("\n" + "%-5.30s  %-5.30s  %-5.30s", getTitle(), getAuthor(), getYear());
    }
}

