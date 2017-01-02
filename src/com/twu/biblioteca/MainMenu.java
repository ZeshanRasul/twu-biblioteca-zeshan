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
        System.out.println();
        System.out.println("What would you like to do today?");
        System.out.println("Please enter the correct number");
        System.out.println("1. List books");
        System.out.println("2. Check out book");
        System.out.println("3. Return book");
        System.out.println("9. Quit");
    }

    public int menuScanner() {
        Scanner scanner = new Scanner(System.in);
        int selection = Integer.parseInt(scanner.nextLine());
        return selection;
    }

    public boolean runCommand(int optionNumber) {
        switch(optionNumber) {
            case 1: listBookLibrary();
                    break;
            case 2: listBookLibrary();
                    checkOutBook();
                    break;
            case 3: returnBook();
                    break;
            case 9: System.out.print("Thank you for using Biblioteca!");
                    return BibliotecaApp.runMenu = false;
            default:
                System.out.print("Please enter a valid option!");
                break;
        }
        return true;
    }

    private void returnBook() {
        System.out.println();
        System.out.println("Which book would you like to return?");
        Scanner newScanner = new Scanner(System.in);
        String bookName = newScanner.nextLine();
        System.out.println(bookName);
        for (Book b : bookLibrary) {
            if (b.getTitle().equals(bookName)) {
                if (b.checkedOut) {
                    b.returnBook();
                    System.out.println("Thank you for returning " + bookName);
                    break;
                } else {
                    System.out.println("You cannot return this book");
                }
            }
        }
    }

    public void createBookLibrary() {
        bookLibrary = libraryCreator.createBookLibrary();
    }

    public void listBookLibrary() {
        libraryLister.displayBooks(bookLibrary);
    }

    public void checkOutBook() {
        System.out.println();
        System.out.println("Please select the book to check out");
        Scanner newScanner = new Scanner(System.in);
        String bookName = newScanner.nextLine();
        System.out.println(bookName);
        for (Book b : bookLibrary) {
            if (b.getTitle().equals(bookName)) {
                if (!b.checkedOut) {
                    b.checkOut();
                    System.out.println("You have successfully checked out " + b.getTitle());
                    break;
                } else {
                    System.out.println("This book is not available");
                }
            }

        }
    }
}
