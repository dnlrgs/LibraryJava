package com.dnlrgs.library.view;

import com.dnlrgs.library.controller.LibraryController;

import java.io.IOException;
import java.util.Scanner;

public class LibraryView {
    Scanner scanner = new Scanner(System.in);
    LibraryController controller = new LibraryController();

    public void startMenu() throws IOException {
        boolean running = true;

        while (running) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1: handleAddBook();
            }

        }


    }

    private void printMenu () {
        clearScreen();

        System.out.println("╔══════════════════════════════╗");
        System.out.println("║     LIBRARY MANAGEMENT      ║");
        System.out.println("╠══════════════════════════════╣");
        System.out.println("║ 1. Add New Book             ║");
        System.out.println("║ 2. View All Books           ║");
        System.out.println("║ 3. Borrow Book              ║");
        System.out.println("║ 4. Return Book              ║");
        System.out.println("║ 5. Search Books             ║");
        System.out.println("║ 0. Exit                     ║");
        System.out.println("╚══════════════════════════════╝");
        System.out.print("Select option: ");



    }

    private void clearScreen() {
        // Simple clear for most terminals
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void handleAddBook() throws IOException {
        System.out.print("Enter book's title: \n");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();

        controller.addNewBook(title, author);
    }
}
