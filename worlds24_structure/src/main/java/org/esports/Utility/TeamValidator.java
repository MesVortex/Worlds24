package org.esports.Utility;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TeamValidator {

    public static Long getTeamId(Scanner scanner) {
        Long teamId = null;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter the ID of the team: ");
                teamId = scanner.nextLong();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid team ID (number).");
                scanner.next(); // Clear invalid input
            }
        }
        return teamId;
    }

    public static String getTeamName(Scanner scanner) {
        System.out.print("Enter team name: ");
        return scanner.nextLine();
    }

    public static int getTeamRanking(Scanner scanner) {
        System.out.print("Enter team ranking: ");
        return scanner.nextInt();
    }

    public static boolean isValidTeamName(String name) {
        return name != null && !name.trim().isEmpty() && name.length() <= 100;
    }

    public static boolean isValidTeamRanking(int ranking) {
        return ranking >= 0;
    }
}
