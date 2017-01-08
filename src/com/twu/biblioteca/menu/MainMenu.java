package com.twu.biblioteca.menu;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.itemlisters.LibraryLister;
import com.twu.biblioteca.itemlisters.MovieLibraryLister;
import com.twu.biblioteca.items.Book;
import com.twu.biblioteca.items.Movie;
import com.twu.biblioteca.librarycreators.LibraryCreator;
import com.twu.biblioteca.librarycreators.MovieLibraryCreator;
import com.twu.biblioteca.user.User;
import com.twu.biblioteca.user.UserSystem;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by zeshanrasul on 01/01/2017.
 */
public class MainMenu {

    private LibraryCreator libraryCreator = new LibraryCreator();
    private LibraryLister libraryLister = new LibraryLister();
    private MovieLibraryCreator movieLibraryCreator = new MovieLibraryCreator();
    private MovieLibraryLister movieLibraryLister = new MovieLibraryLister();
    public ArrayList<Book> bookLibrary;
    public ArrayList<Movie> movieLibrary;
    public UserSystem userSystem = new UserSystem();

    public static void displayMenu() {
        System.out.println();
        System.out.println();
        System.out.println("What would you like to do today?");
        System.out.println("Please enter the correct number");
        System.out.println("1. List books");
        System.out.println("2. Check out book");
        System.out.println("3. Return book");
        System.out.println("4. List movies");
        System.out.println("5. Check out movie");
        System.out.println("6. Return movie");
        System.out.println("7. Login");
        System.out.println("8. Logout");
        System.out.println("9. Quit");
        System.out.println("10. Check details");
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
            case 4: listMovieLibrary();
                    break;
            case 5: listMovieLibrary();
                    checkOutMovie();
                    break;
            case 6: returnMovie();
                    break;
            case 7: userSystem.createAllUsers();
                    login();
                    break;
            case 8: logout();
                    break;
            case 9: System.out.print("Thank you for using Biblioteca!");
                    return BibliotecaApp.runMenu = false;
            case 10: checkDetails();
                break;
            default:
                System.out.print("Please enter a valid option!");
                break;
        }
        return true;
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
        if (userSystem.getCurrentUser() == null) {
            System.out.println("You must be logged in to check out a book");
        } else {
            for (Book b : bookLibrary) {
                if (b.getTitle().equals(bookName)) {
                    if (!b.checkedOut) {
                        b.checkOut();
                        b.setHolder(userSystem.getCurrentUser());
                        System.out.println("You have successfully checked out " + b.getTitle() + ",user: " + b.getHolder().getLibraryNumber());
                        break;
                    } else {
                        System.out.println("This book is not available");
                    }
                }

            }
        }
    }

    private void returnBook() {
        System.out.println();
        System.out.println("Which book would you like to return?");
        Scanner newScanner = new Scanner(System.in);
        String bookName = newScanner.nextLine();
//        System.out.println(bookName);
        if (userSystem.getCurrentUser() == null) {
            System.out.println("You must be logged in to return books");
        } else {
            for (Book b : bookLibrary) {
                if (b.getTitle().equals(bookName)) {
                    if (b.checkedOut && b.getHolder().getLibraryNumber() == userSystem.getCurrentUser().getLibraryNumber()) {
                        b.returnBook();
                        System.out.println("Thank you for returning " + bookName);
                        break;
                    } else {
                        System.out.println("You cannot return this book");
                    }
                }
            }
        }
    }

    public void createMovieLibrary() {
        movieLibrary = movieLibraryCreator.createMovieLibrary();
    }

    public void listMovieLibrary() {
        movieLibraryLister.displayMovies(movieLibrary);
    }

    private void checkOutMovie() {
        System.out.println();
        System.out.println("Please select the movie to check out");
        Scanner newScanner = new Scanner(System.in);
        String movieName = newScanner.nextLine();
        System.out.println(movieName);
        if (userSystem.getCurrentUser() == null) {
            System.out.println("You must be logged in to check out a movies");
        } else {
            for (Movie m : movieLibrary) {
                if (m.getTitle().equals(movieName)) {
                    if (!m.checkedOut) {
                        m.checkOut();
                        m.setHolder(userSystem.getCurrentUser());
                        System.out.println("You have successfully checked out " + m.getTitle());
                        break;
                    } else {
                        System.out.println("This movie is not available");
                    }
                }
            }
        }
    }

    private void returnMovie() {
        System.out.println();
        System.out.println("Which movie would you like to return?");
        Scanner newScanner = new Scanner(System.in);
        String movieName = newScanner.nextLine();
        if (userSystem.getCurrentUser() == null) {
            System.out.println("You must be logged in to return movies");
        } else {
            for (Movie m : movieLibrary) {
                if (m.getTitle().equals(movieName)) {
                    if (m.checkedOut && m.getHolder().getLibraryNumber() == userSystem.getCurrentUser().getLibraryNumber()) {
                        m.returnMovie();
                        System.out.println("Thank you for returning " + m.getTitle());
                        break;
                    } else {
                        System.out.println("You cannot return this movie");
                    }
                }
            }
        }
    }

    private void login() {
        if (userSystem.getCurrentUser() == null) {
            System.out.println();
            System.out.println("Please enter your login number");
            Scanner loginScanner = new Scanner(System.in);
            String loginNumber = loginScanner.nextLine();
            System.out.println("Please enter your password");
            Scanner passScanner = new Scanner(System.in);
            String password = passScanner.nextLine();
            userSystem.authenticate(loginNumber, password);
            System.out.println("Welcome User " + loginNumber);
        } else {
            System.out.println();
            System.out.println("You are already logged in!");
        }
    }

    private void checkDetails() {
        System.out.println(userSystem.getCurrentUser().getLibraryNumber());
        System.out.println((userSystem.getCurrentUser().getPassword()));
    }


    private void logout() {
        if (userSystem.getCurrentUser() != null) {
            System.out.println();
            System.out.println("You have successfully logged out!");
            userSystem.setCurrentUser(null);
        } else {
            System.out.println();
            System.out.println("You are not logged in!");
        }
    }
}
