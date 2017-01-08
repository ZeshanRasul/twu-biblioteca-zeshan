package com.twu.biblioteca.menu;
import com.twu.biblioteca.user.User;
import com.twu.biblioteca.user.UserSystem;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.allOf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

/**
 * Created by zeshanrasul on 01/01/2017.
 */
public class MainMenuTest {
    private ByteArrayOutputStream outputStream;
    private MainMenu mainMenu = new MainMenu();
    private UserSystem userSystem = new UserSystem();
    private User user = new User ("111-1111", "password");
    @Before
    public void beforeEach() {
        outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        mainMenu = new MainMenu();
        mainMenu.displayMenu();
    }

    @Test
    public void displayMenuDisplaysAllMenuOptions() {
//        mainMenu = new MainMenu();
//        mainMenu.displayMenu();
        assertThat(outputStream.toString(), containsString("1. List books"));
    }

    @Test
    public void menuScannerReturnsTheUserInput() {
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        assertEquals(1, mainMenu.menuScanner());
    }

    @Test
    public void runCommandRunsACommandBasedOnInput() {
        mainMenu.createBookLibrary();
        mainMenu.runCommand(1);
        assertThat(outputStream.toString(), allOf(containsString("Blink"), containsString("The Alchemist"), containsString("The Prince")));
    }

    @Test
    public void userToldToEnterValidChoiceWhenInvalidChoiceMade() {
        mainMenu.runCommand(1000);
        assertThat(outputStream.toString(), containsString("Please enter a valid option!"));
    }

    @Test
    public void userCanCheckOutBookUsingOption() {
        String data = "Blink";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        mainMenu.createBookLibrary();
        mainMenu.runCommand(2);
        assertThat(outputStream.toString(), containsString("You have successfully checked out Blink"));
    }

    @Test
    public void userCannotCheckOutBookIfNotLoggedIn() {
        String data = "Blink";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        mainMenu.createBookLibrary();
        mainMenu.runCommand(2);
        assertThat(outputStream.toString(), containsString("You must be logged in to check out a book"));
    }

    @Test
    public void userCanCheckOutBookIfLoggedIn() {
//        userSystem.currentUser = user;
        String data = "Blink";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        mainMenu.createBookLibrary();
        userSystem.createAllUsers();
        userSystem.authenticate(userSystem.allUsers.get(0).getLibraryNumber(), userSystem.allUsers.get(0).getPassword());
        System.out.println(userSystem.getCurrentUser());
        mainMenu.runCommand(2);
        assertThat(outputStream.toString(), containsString("You have successfully checked out Blink, user: 111-1111" ));

    }
//
    @Test
    public void userCannotReturnBooksThatAreNotHeldByThem() {
        userSystem.createAllUsers();
        userSystem.authenticate("111-1111", "firstpass");
        String data = "Blink";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        mainMenu.createBookLibrary();
        mainMenu.runCommand(2);
        userSystem.authenticate("222-2222", "secondpass");
        String secondData = "Blink";
        System.setIn(new ByteArrayInputStream(secondData.getBytes()));
        mainMenu.runCommand(3);
        assertThat(outputStream.toString(), containsString("You are not the holder of that book."));
    }

    @Test
    public void userCannotCheckOutABookThatIsAlreadyCheckedOut() {
        String data = "The Prince";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        mainMenu.createBookLibrary();
        mainMenu.runCommand(2);
        String secondData = "The Prince";
        System.setIn(new ByteArrayInputStream(secondData.getBytes()));
        mainMenu.runCommand(2);
        assertThat(outputStream.toString(), containsString("This book is not available"));
    }

    @Test
    public void userCanReturnBookUsingMenuOption() {
        String data = "The Alchemist";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        mainMenu.createBookLibrary();
        mainMenu.runCommand(2);
        String secondData = "The Alchemist";
        System.setIn(new ByteArrayInputStream(secondData.getBytes()));
        mainMenu.runCommand(3);
        assertThat(outputStream.toString(), containsString("Thank you for returning The Alchemist"));
    }

    @Test
    public void userCannotReturnBooksThatAreNotCheckedOut() {
        String data = "The Prince";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        mainMenu.createBookLibrary();
        mainMenu.runCommand(3);
        assertThat(outputStream.toString(), containsString("You cannot return this book"));
    }

    @Test
    public void userCanCheckOutMovieUsingOption() {
        String data = "The Godfather: Part III";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        mainMenu.createMovieLibrary();
        mainMenu.runCommand(5);
        assertThat(outputStream.toString(), containsString("You have successfully checked out The Godfather: Part III"));
    }

    @Test
    public void userCannotCheckOutAMovieThatIsAlreadyCheckedOut() {
        String data = "The Godfather: Part III";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        mainMenu.createMovieLibrary();
        mainMenu.runCommand(5);
        String newData = "The Godfather: Part III";
        System.setIn(new ByteArrayInputStream(newData.getBytes()));
        mainMenu.runCommand(5);
        assertThat(outputStream.toString(), containsString("This movie is not available"));
    }

    @Test
    public void userCanReturnMovieThatHasBeenCheckedOut() {
        String data = "The Godfather";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        mainMenu.createMovieLibrary();
        mainMenu.runCommand(5);
        String secondData = "The Godfather";
        System.setIn(new ByteArrayInputStream(secondData.getBytes()));
        mainMenu.runCommand(6);
        assertThat(outputStream.toString(), containsString("Thank you for returning The Godfather"));
    }

    @Test
    public void userCannotReturnAMovieThatIsNotCheckedOut() {
        String data = "The Godfather: Part III";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        mainMenu.createMovieLibrary();
        mainMenu.runCommand(6);
        assertThat(outputStream.toString(), containsString("You cannot return this movie"));
    }

    @Test
    public void userCanLoginUsingMenuOpiton() {
        String loginDetails = "111-1111" + "\npassword";
        System.setIn(new ByteArrayInputStream(loginDetails.getBytes()));
//        String password = "password";
//        System.setIn(new ByteArrayInputStream(password.getBytes()));
        mainMenu.runCommand(7);
        assertThat(outputStream.toString(), containsString("Welcome User 111-1111"));

    }

    @Test
    public void quitOptionAvailableOnMenu() {
        mainMenu.runCommand(9);
        assertThat(outputStream.toString(), containsString("Thank you for using Biblioteca!"));
    }



}