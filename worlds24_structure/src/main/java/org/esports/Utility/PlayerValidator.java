package org.esports.Utility;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PlayerValidator {

    public static String getPlayerName(Scanner sc) {
        System.out.println("Enter Player Name:");
        return sc.next();
    }

    public static int getPlayerAge(Scanner sc) {
        int age = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("Enter Player Age:");
                age = sc.nextInt();
                if (age <= 0) {
                    throw new InputMismatchException();
                }
                validInput = true; // Exit the loop if valid
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid age.");
                sc.next(); // Clear invalid input
            }
        }
        return age;
    }
}
