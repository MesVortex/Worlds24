package org.esports.Utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameValidator {

    private static final Logger logger = LoggerFactory.getLogger(GameValidator.class);

    public static Long getGameId(Scanner scanner) {
        Long gameId = null;
        boolean validInput = false;
        while (!validInput) {
            try {
                logger.info("Enter the ID of the game: ");
                gameId = scanner.nextLong();
                validInput = true;
            } catch (InputMismatchException e) {
                logger.warn("Invalid input! Please enter a valid game ID (number).");
                scanner.next(); // Clear invalid input
            }
        }
        return gameId;
    }

    public static String getGameName(Scanner scanner) {
        String name;
        do {
            logger.info("Enter game name (1-100 characters): ");
            name = scanner.nextLine();
        } while (name.isEmpty() || name.length() > 100);
        return name;
    }

    public static int getDifficulty(Scanner scanner) {
        while (true) {
            try {
                logger.info("Enter game difficulty (e.g., 1-10): ");
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                logger.warn("Invalid input. Please enter an integer for difficulty.");
            }
        }
    }

    public static int getAverageDuration(Scanner scanner) {
        while (true) {
            try {
                logger.info("Enter average duration (in minutes): ");
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                logger.warn("Invalid input. Please enter an integer for duration.");
            }
        }
    }
}