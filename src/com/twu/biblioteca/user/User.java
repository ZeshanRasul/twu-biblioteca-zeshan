package com.twu.biblioteca.user;

/**
 * Created by zeshanrasul on 07/01/2017.
 */
public class User {

    private String libraryNumber;
    private String password;

    public User(String ln, String pass) {
        libraryNumber = ln;
        password = pass;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public String getPassword() {
        return password;
    }
}
