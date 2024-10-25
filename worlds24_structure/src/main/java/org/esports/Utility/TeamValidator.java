package org.esports.Utility;

import java.util.Scanner;

public class TeamValidator {

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
