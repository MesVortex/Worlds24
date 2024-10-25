package org.esports.View;

import java.util.InputMismatchException;
import java.util.Scanner;
import org.esports.Service.GameService;
import org.esports.Service.PlayerService;
import org.esports.Service.TeamService;
import org.esports.Service.TournamentService;
import org.esports.Utility.PlayerValidator;

public class ConsoleUI {
    private final GameService gameService;
    private final PlayerService playerService;
    private final TeamService teamService;
    private final TournamentService tournamentService;
    private final Scanner scanner = new Scanner(System.in);

    public ConsoleUI(GameService gameService, PlayerService playerService, TeamService teamService, TournamentService tournamentService) {
        this.gameService = gameService;
        this.playerService = playerService;
        this.teamService = teamService;
        this.tournamentService = tournamentService;
    }

    public void showMenu() {
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("Select an option:");
                System.out.println("1. Player Management");
                System.out.println("2. Team Management");

                int choice = scanner.nextInt();
                validInput = true; // If input is valid, exit the loop

                switch (choice) {
                    case 1:
                        managePlayers();
                        break;
                    case 2:
                        manageTeams();
                        break;
                    default:
                        System.out.println("Invalid option.");
                        validInput = false; // If invalid option, repeat
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                scanner.next(); // Clear invalid input
            }
        }
    }

    private void managePlayers() {
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("Player Management:");
                System.out.println("1. Create Player");
                System.out.println("2. Update Player");
                System.out.println("3. Delete Player");

                int choice = scanner.nextInt();
                validInput = true;

                switch (choice) {
                    case 1:
                        createPlayer();
                        break;
                    case 2:
                        updatePlayer();
                        break;
                    case 3:
                        deletePlayer();
                        break;
                    default:
                        System.out.println("Invalid option.");
                        validInput = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                scanner.next(); // Clear invalid input
            }
        }
    }

    private void manageTeams() {
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("Team Management:");
                System.out.println("1. Create Team");
                System.out.println("2. Update Team");
                System.out.println("3. Delete Team");

                int choice = scanner.nextInt();
                validInput = true;

                switch (choice) {
                    case 1:
                        // Call teamService.createTeam() and handle input
                        break;
                    case 2:
                        // Call teamService.updateTeam() and handle input
                        break;
                    case 3:
                        // Call teamService.deleteTeam() and handle input
                        break;
                    default:
                        System.out.println("Invalid option.");
                        validInput = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                scanner.next(); // Clear invalid input
            }
        }
    }

    private void createPlayer() {
        String name = PlayerValidator.getPlayerName(scanner);
        int age = PlayerValidator.getPlayerAge(scanner);

        if(playerService.addPlayer(name, age)){
            System.out.println("Player created successfully.");
        }else{
            System.out.println("Player creation failed.");
        }
    }

    private void updatePlayer() {
        System.out.print("Enter the ID of the player to update: ");
        Long playerId = scanner.nextLong();
        scanner.nextLine(); // Clear buffer

        String updatedName = PlayerValidator.getPlayerName(scanner);
        int updatedAge = PlayerValidator.getPlayerAge(scanner);

        if (playerService.updatePlayer(playerId, updatedName, updatedAge)) {
            System.out.println("Player updated successfully.");
        } else {
            System.out.println("Player update failed.");
        }
    }

    private void deletePlayer() {
        System.out.print("Enter the ID of the player to delete: ");
        Long playerId = scanner.nextLong();
        scanner.nextLine(); // Clear buffer

        if (playerService.deletePlayer(playerId)) {
            System.out.println("Player deleted successfully.");
        } else {
            System.out.println("Player deletion failed. Player not found.");
        }
    }


}
