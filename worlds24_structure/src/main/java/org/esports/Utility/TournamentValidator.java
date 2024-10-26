package org.esports.Utility;

import org.esports.Model.Enum.TournamentStatus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TournamentValidator {
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static Long getTournamentId(Scanner scanner) {
        Long tournamentId = null;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter the ID of the tournament: ");
                tournamentId = scanner.nextLong();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid tournament ID (number).");
                scanner.next(); // Clear invalid input
            }
        }
        return tournamentId;
    }

    public static String getTournamentTitle(Scanner scanner) {
        System.out.print("Enter tournament title: ");
        return scanner.nextLine();
    }

    public static LocalDate getTournamentStartDate(Scanner scanner) {
        return getLocalDateInput(scanner, "Enter tournament start date (YYYY-MM-DD): ");
    }

    public static LocalDate getTournamentEndDate(Scanner scanner) {
        return getLocalDateInput(scanner, "Enter tournament end date (YYYY-MM-DD): ");
    }

    private static LocalDate getLocalDateInput(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String dateInput = scanner.nextLine();
            try {
                return LocalDate.parse(dateInput, dateFormatter);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter the date in DD/MM/YYYY format.");
            }
        }
    }

    public static int getNumberOfSpectators(Scanner scanner) {
        while (true) {
            System.out.print("Enter number of spectators: ");
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // Clear invalid input
            }
        }
    }

    public static int getEstimatedDuration(Scanner scanner) {
        while (true) {
            System.out.print("Enter estimated duration (in minutes): ");
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // Clear invalid input
            }
        }
    }

    public static int getBreakBetweenGames(Scanner scanner) {
        while (true) {
            System.out.print("Enter break between games (in minutes): ");
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // Clear invalid input
            }
        }
    }

    public static int getCeremonyTime(Scanner scanner) {
        while (true) {
            System.out.print("Enter ceremony time (in minutes): ");
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // Clear invalid input
            }
        }
    }


    public static TournamentStatus getTournamentStatus(Scanner scanner) {
        scanner.nextLine();
        while (true) {
            System.out.print("Enter tournament status (e.g., PLANNED, IN_PROGRESS, COMPLETED, CANCELLED): ");
            String input = scanner.nextLine().toUpperCase();
            try {
                return TournamentStatus.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid status. Please enter one of the following: PLANNED, IN_PROGRESS, COMPLETED, CANCELLED.");
            }
        }
    }
}
