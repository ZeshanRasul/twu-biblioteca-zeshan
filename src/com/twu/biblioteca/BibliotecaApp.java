package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp.run();
    }

    public static void run(){
        Message message = new Message();
        message.welcomeMessage();
        MainMenu mainMenu = new MainMenu();
        mainMenu.displayMenu();
        mainMenu.runCommand(mainMenu.menuScanner());
    }


}
