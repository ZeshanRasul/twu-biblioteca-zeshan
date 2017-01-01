package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by zeshanrasul on 01/01/2017.
 */
public class MainMenu {

    private LibraryCreator libraryCreator = new LibraryCreator();
    private LibraryLister libraryLister = new LibraryLister();
    public ArrayList<Book> bookLibrary;

    public static void displayMenu() {
        System.out.println();
        System.out.println("What would you like to do today?");
        System.out.println("Please enter the correct number");
        System.out.println("1. List books");
        System.out.println("9. Quit");
    }

    public int menuScanner() {
        Scanner scanner = new Scanner(System.in);
        int selection = Integer.parseInt(scanner.nextLine());
        return selection;
    }

    public boolean runCommand(int optionNumber) {
        switch(optionNumber) {
            case 1: bookLibrary = libraryCreator.createBookLibrary();
                    libraryLister.displayBooks(bookLibrary);
                    break;
            case 9: System.out.print("Thank you for using Biblioteca!");
                    return BibliotecaApp.runMenu = false;
            default:
                System.out.print("Please enter a valid option!");
                break;
        }
        return true;
    }
}
