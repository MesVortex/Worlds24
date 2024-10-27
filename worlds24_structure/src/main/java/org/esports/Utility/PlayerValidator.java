package org.esports.Utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PlayerValidator {

    private static final Logger logger = LoggerFactory.getLogger(PlayerValidator.class);

    public static Long getPlayerId(Scanner scanner) {
        Long playerId = null;
        boolean validInput = false;
        while (!validInput) {
            try {
                logger.info("Enter the ID of the player: ");
                playerId = scanner.nextLong();
                validInput = true;
            } catch (InputMismatchException e) {
                logger.warn("Invalid input! Please enter a valid player ID (number).");
                scanner.next(); // Clear invalid input
            }
        }
        return playerId;
    }

    public static String getPlayerName(Scanner sc) {
        logger.info("Enter Player Name:");
        return sc.next();
    }

    public static int getPlayerAge(Scanner sc) {
        int age = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                logger.info("Enter Player Age:");
                age = sc.nextInt();
                if (age <= 0) {
                    throw new InputMismatchException();
                }
                validInput = true; // Exit the loop if valid
            } catch (InputMismatchException e) {
                logger.warn("Invalid input. Please enter a valid age.");
                sc.next(); // Clear invalid input
            }
        }
        return age;
    }
}