package com.twu.biblioteca.user;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by zeshanrasul on 07/01/2017.
 */
public class UserSystem {
    public ArrayList<User> allUsers;
    public User currentUser;

    public ArrayList<User> createAllUsers() {

        User firstUser = new User("111-1111", "firstpass");
        User secondUser = new User("222-2222", "secondpass");
        User thirdUser = new User("333-3333", "thirdpass");

        allUsers = new ArrayList<User>(Arrays.asList(firstUser, secondUser, thirdUser));
        return allUsers;

    }

    public User authenticate(String libNo, String pass) {
        for(User u : allUsers) {
            if (u.getLibraryNumber().equals(libNo)) {
                if (u.getPassword().equals(pass)) {
                    setCurrentUser(u);
                    return currentUser;
                }
            }
        }
        return null;
    }

    public void setCurrentUser(User user) {
        currentUser = user;
    }

    public User getCurrentUser() {
        return currentUser;
    }


}
