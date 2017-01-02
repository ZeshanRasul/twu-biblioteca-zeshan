package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by zeshanrasul on 31/12/2016.
 */
public class LibraryLister {

    public void displayBooks(ArrayList<Book> bookList) {
        System.out.printf("\n" + "\n" + "%-25.30s  %-25.30s  %-25.30s", "Title", "Author", "Year");
        for(Book b : bookList) {
            if (!b.checkedOut) {
                b.printDetails();
            }
        }
    }

}
