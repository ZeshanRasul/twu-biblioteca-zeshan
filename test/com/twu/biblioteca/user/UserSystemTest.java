package com.twu.biblioteca.user;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by zeshanrasul on 07/01/2017.
 */
public class UserSystemTest {

    private User firstUser;
    private User secondUser;
    private User thirdUser;
    private UserSystem userSystem;
    private ArrayList<User> allUsers;

    @Before
    public void beforeEach() {
        firstUser = new User("111-1111", "firstpass");
        secondUser = new User("222-2222", "secondpass");
        thirdUser = new User("333-3333", "thirdpass");
        userSystem = new UserSystem();
        allUsers = userSystem.createAllUsers();
    }

    @Test
    public void createAllUsersCreatesAnArrayListContainingUsers() {
        assertEquals(3, allUsers.size());
    }

    @Test
    public void authenticateChecksThroughAllUsersAndSavesExistingUserAsCurrentUSer() {
        userSystem.authenticate("111-1111", "firstpass");
        assertEquals(userSystem.currentUser.getLibraryNumber(), "111-1111");
    }


}