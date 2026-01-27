package com.dnlrgs.library.view;

import java.util.Scanner;

public class LibraryView {
    Scanner scanner = new Scanner(System.in);

    public void startMenu(){
        boolean running = true;

        while (running) {
            printMenu();
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
        int chose = scanner.nextInt();
        scanner.nextLine();

    }

    private void clearScreen() {
        // Simple clear for most terminals
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
