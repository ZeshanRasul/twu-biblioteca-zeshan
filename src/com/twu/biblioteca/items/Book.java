package com.twu.biblioteca.items;

import com.twu.biblioteca.user.User;

/**
 * Created by zeshanrasul on 30/12/2016.
 */
public class Book {

    private String title;
    private String author;
    private int year;
    public boolean checkedOut;
    private User holder;

    public Book(String t, String a, int y) {
        title = t;
        author = a;
        year = y;
        checkedOut = false;
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
        System.out.printf("\n" + "%-25.30s  %-25.30s  %-4.30s", getTitle(), getAuthor(), getYear());
    }

    public void checkOut() {
        checkedOut = true;
    }

    public void returnBook() {
        checkedOut = false;
    }

    public User getHolder() {
        return holder;
    }
}

