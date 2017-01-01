package com.twu.biblioteca;
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
    private MainMenu mainMenu;

    @Before
    public void beforeEach() {
        outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        mainMenu = new MainMenu();
    }

    @Test
    public void displayMenuDisplaysAllMenuOptions() {
        mainMenu = new MainMenu();
        mainMenu.displayMenu();
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
        mainMenu.runCommand(1);
        assertThat(outputStream.toString(), allOf(containsString("Blink"), containsString("The Alchemist"), containsString("The Prince")));
    }

    @Test
    public void userToldToEnterValidChoiceWhenInvalidChoiceMade() {
        mainMenu.runCommand(1000);
        assertEquals("Please enter a valid option!", outputStream.toString());
    }

    @Test
    public void quitOptionAvailableOnMenu() {
        mainMenu.runCommand(9);
        assertEquals("Thank you for using Biblioteca!", outputStream.toString());
    }



}