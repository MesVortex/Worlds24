package org.esports.Utility;

import java.util.Scanner;

public class GameValidator {

    public static String getGameName(Scanner scanner) {
        String name;
        do {
            System.out.print("Enter game name (1-100 characters): ");
            name = scanner.nextLine();
        } while (name.isEmpty() || name.length() > 100);
        return name;
    }

    public static int getDifficulty(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Enter game difficulty (e.g., 1-10): ");
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer for difficulty.");
            }
        }
    }

    public static int getAverageDuration(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Enter average duration (in minutes): ");
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer for duration.");
            }
        }
    }
}
