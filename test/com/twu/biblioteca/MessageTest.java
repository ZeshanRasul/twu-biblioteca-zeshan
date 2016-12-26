package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Created by zeshanrasul on 26/12/2016.
 */
public class MessageTest {

    private ByteArrayOutputStream outputStream;
    private Message message;

    @Before
    public void beforeEach() {
        outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
    }

    @Test
    public void welcomeMessageIsPrinted() {
        message = new Message();
        message.welcomeMessage();
        assertEquals("Welcome to Biblioteca!", outputStream.toString());
    }

}