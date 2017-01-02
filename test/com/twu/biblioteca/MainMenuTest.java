package com.twu.biblioteca;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.allOf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

/**
 * Created by zeshanrasul on 01/01/2017.
 */
public class MainMenuTest {
    private ByteArrayOutputStream outputStream;
    private MainMenu mainMenu = new MainMenu();

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
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        mainMenu.createBookLibrary();
        mainMenu.runCommand(2);
        assertThat(outputStream.toString(), containsString("You have successfully checked out Blink"));
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
    public void quitOptionAvailableOnMenu() {
        mainMenu.runCommand(9);
        assertThat(outputStream.toString(), containsString("Thank you for using Biblioteca!"));
    }



}