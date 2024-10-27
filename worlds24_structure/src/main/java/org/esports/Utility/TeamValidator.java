package org.esports.Utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TeamValidator {

    private static final Logger logger = LoggerFactory.getLogger(TeamValidator.class);

    public static Long getTeamId(Scanner scanner) {
        Long teamId = null;
        boolean validInput = false;
        while (!validInput) {
            try {
                logger.info("Enter the ID of the team: ");
                teamId = scanner.nextLong();
                validInput = true;
            } catch (InputMismatchException e) {
                logger.warn("Invalid input! Please enter a valid team ID (number).");
                scanner.next(); // Clear invalid input
            }
        }
        return teamId;
    }

    public static String getTeamName(Scanner scanner) {
        logger.info("Enter team name: ");
        return scanner.nextLine();
    }

    public static int getTeamRanking(Scanner scanner) {
        int ranking = -1;
        boolean validInput = false;
        while (!validInput) {
            try {
                logger.info("Enter team ranking: ");
                ranking = scanner.nextInt();
                if (ranking < 0) {
                    logger.warn("Ranking cannot be negative. Please enter a valid ranking.");
                } else {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                logger.warn("Invalid input! Please enter a valid ranking (number).");
                scanner.next(); // Clear invalid input
            }
        }
        return ranking;
    }

    public static boolean isValidTeamName(String name) {
        return name != null && !name.trim().isEmpty() && name.length() <= 100;
    }

    public static boolean isValidTeamRanking(int ranking) {
        return ranking >= 0;
    }
}