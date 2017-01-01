package com.twu.biblioteca;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import static com.sun.jmx.snmp.ThreadContext.contains;
import static org.hamcrest.CoreMatchers.allOf;
import static org.junit.matchers.JUnitMatchers.*;

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



}