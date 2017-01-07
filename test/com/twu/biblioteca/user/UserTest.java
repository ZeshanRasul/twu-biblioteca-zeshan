package com.twu.biblioteca.user;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zeshanrasul on 07/01/2017.
 */
public class UserTest {

    private User user;

    @Before
    public void beforeEach() {
        user = new User("555-5555", "password");
    }

    @Test
    public void getLibraryNumberReturnsUserLibraryNumber() {
        assertEquals("555-5555", user.getLibraryNumber());
    }

    @Test
    public void getPasswordReturnsUserPassword() {
        assertEquals("password", user.getPassword());
    }
}