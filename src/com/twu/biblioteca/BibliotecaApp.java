package com.twu.biblioteca;

import com.twu.biblioteca.display.Message;
import com.twu.biblioteca.menu.MainMenu;
import com.twu.biblioteca.user.UserSystem;

public class BibliotecaApp {

    public static boolean runMenu = true;

    public static void main(String[] args) {
        BibliotecaApp.run();
    }

    public static void run(){
        Message message = new Message();
        message.welcomeMessage();
        MainMenu mainMenu = new MainMenu();
        mainMenu.createBookLibrary();
        mainMenu.createMovieLibrary();

        while(runMenu) {
            mainMenu.displayMenu();
            mainMenu.runCommand(mainMenu.menuScanner());
        }
    }


}
