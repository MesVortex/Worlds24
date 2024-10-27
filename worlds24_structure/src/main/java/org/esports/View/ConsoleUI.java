package org.esports.View;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.esports.Model.Enum.TournamentStatus;
import org.esports.Model.Game;
import org.esports.Model.Player;
import org.esports.Model.Team;
import org.esports.Model.Tournament;
import org.esports.Service.GameService;
import org.esports.Service.PlayerService;
import org.esports.Service.TeamService;
import org.esports.Service.TournamentService;
import org.esports.Utility.GameValidator;
import org.esports.Utility.PlayerValidator;
import org.esports.Utility.TeamValidator;
import org.esports.Utility.TournamentValidator;

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

    private int getMenuSelection(String prompt, int max) {
        while (true) {
            try {
                System.out.println(prompt);
                int choice = scanner.nextInt();
                scanner.nextLine(); // Clear buffer
                if (choice >= 1 && choice <= max) return choice;
                System.out.println("Please choose a valid option.");
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                scanner.next();
            }
        }
    }

    public void showMenu() {
        while (true) {
            String menuPrompt = "Select an option:\n" +
                    "1. Player Management\n" +
                    "2. Team Management\n" +
                    "3. Tournament Management\n" +
                    "4. Game Management\n" +
                    "5. Exit";
            int choice = getMenuSelection(menuPrompt, 5);

            switch (choice) {
                case 1:
                    managePlayers();
                    break;
                case 2:
                    manageTeams();
                    break;
                case 3:
                    manageTournaments();
                    break;
                case 4:
                    manageGames();
                    break;
                case 5:
                    System.out.println("Exiting the application. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
    }

    private void managePlayers() {
        String playerMenu = "Player Management:\n" +
                "1. Create Player\n" +
                "2. Update Player\n" +
                "3. Delete Player\n" +
                "4. Show Player Details";
        int choice = getMenuSelection(playerMenu, 4);

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
            case 4:
                showPlayerDetails();
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    private void manageTeams() {
        String teamMenu = "Team Management:\n" +
                "1. Create Team\n" +
                "2. Update Team\n" +
                "3. Add player to a team\n" +
                "4. Remove player from a team\n" +
                "5. View All Teams";
        int choice = getMenuSelection(teamMenu, 5);

        switch (choice) {
            case 1:
                createTeam();
                break;
            case 2:
                updateTeam();
                break;
            case 3:
                addPlayerToTeam();
                break;
            case 4:
                removePlayerFromTeam();
                break;
            case 5:
                viewAllTeams();
                break;
            default:
                System.out.println("Invalid option.");
                break;
        }
    }

    private void manageTournaments() {
        String tournamentMenu = "Tournament Management:\n" +
                "1. Create Tournament\n" +
                "2. Update Tournament\n" +
                "3. Add Team to Tournament\n" +
                "4. Remove Team from Tournament\n" +
                "5. Calculate Estimated Duration\n" +
                "6. View All Tournaments";
        int choice = getMenuSelection(tournamentMenu, 6);

        switch (choice) {
            case 1:
                createTournament();
                break;
            case 2:
                updateTournament();
                break;
            case 3:
                addTeamToTournament();
                break;
            case 4:
                removeTeamFromTournament();
                break;
            case 5:
                calculateEstimatedDuration();
                break;
            case 6:
                viewAllTournaments();
                break;
            default:
                System.out.println("Invalid option.");
                break;
        }
    }

    private void manageGames() {
        String gameMenu = "Game Management:\n1. Create Game\n2. Update Game\n3. View All Games";
        int choice = getMenuSelection(gameMenu, 3);

        switch (choice) {
            case 1:
                createGame();
                break;
            case 2:
                updateGame();
                break;
            case 3:
                viewAllGames();
                break;
            default:
                System.out.println("Invalid option.");
                break;
        }
    }

    private void createPlayer() {
        String name = PlayerValidator.getPlayerName(scanner);
        int age = PlayerValidator.getPlayerAge(scanner);

        boolean success = playerService.addPlayer(name, age);
        System.out.println(success ? "Player created successfully." : "Player creation failed.");
    }

    private void updatePlayer() {
        Long playerId = PlayerValidator.getPlayerId(scanner);
        String updatedName = PlayerValidator.getPlayerName(scanner);
        int updatedAge = PlayerValidator.getPlayerAge(scanner);

        boolean success = playerService.updatePlayer(playerId, updatedName, updatedAge);
        System.out.println(success ? "Player updated successfully." : "Player update failed.");
    }

    private void deletePlayer() {
        Long playerId = PlayerValidator.getPlayerId(scanner);

        boolean success = playerService.deletePlayer(playerId);
        System.out.println(success ? "Player deleted successfully." : "Player deletion failed. Player not found.");
    }

    private void showPlayerDetails() {
        Long playerId = PlayerValidator.getPlayerId(scanner);
        Player player = playerService.getPlayer(playerId);
        if (player != null) {
            player.showDetails();
        } else {
            System.out.println("Player not found.");
        }
    }

    private void createTeam() {
        String name = TeamValidator.getTeamName(scanner);
        int ranking = TeamValidator.getTeamRanking(scanner);

        boolean success = teamService.addTeam(name, ranking);
        System.out.println(success ? "Team created successfully." : "Team creation failed.");
    }

    private void updateTeam() {
        Long teamId = TeamValidator.getTeamId(scanner);
        String updatedName = TeamValidator.getTeamName(scanner);
        int updatedRanking = TeamValidator.getTeamRanking(scanner);

        boolean success = teamService.updateTeam(teamId, updatedName, updatedRanking);
        System.out.println(success ? "Team updated successfully." : "Team update failed.");
    }

    private void addPlayerToTeam() {
        Long teamId = TeamValidator.getTeamId(scanner);  // Get team ID
        Long playerId = PlayerValidator.getPlayerId(scanner);  // Get player ID

        Player player = playerService.getPlayer(playerId);

        if (player == null) {
            System.out.println("Player with the specified ID does not exist.");
            return;
        }

        boolean success = teamService.addPlayerToTeam(teamId, player);
        System.out.println(success ? "Player added to team successfully." : "Failed to add player to team.");
    }

    private void removePlayerFromTeam() {
        Long teamId = TeamValidator.getTeamId(scanner);  // Get team ID
        Long playerId = PlayerValidator.getPlayerId(scanner);  // Get player ID

        Player player = playerService.getPlayer(playerId);

        if (player == null) {
            System.out.println("Player with the specified ID does not exist.");
            return;
        }

        boolean success = teamService.removePlayerFromTeam(teamId, player);
        System.out.println(success ? "Player removed from team successfully." : "Failed to remove player from team.");
    }

    private void viewAllTeams() {
        List<Team> teams = teamService.getTeams();
        if (teams.isEmpty()) {
            System.out.println("No teams available.");
        } else {
            for (Team team : teams) {
                team.showDetails();
                System.out.println("-----------");
            }
        }
    }

    private void createTournament() {
        Long gameId = GameValidator.getGameId(scanner);  // Get game ID

        Game game = gameService.getGame(gameId);

        if (game == null) {
            System.out.println("Game with the specified ID does not exist.");
            return;
        }
        String title = TournamentValidator.getTournamentTitle(scanner);
        LocalDate startDate = TournamentValidator.getTournamentStartDate(scanner);
        LocalDate endDate = TournamentValidator.getTournamentEndDate(scanner);
        int numberOfSpectators = TournamentValidator.getNumberOfSpectators(scanner);
        int estimatedDuration = TournamentValidator.getEstimatedDuration(scanner);
        int breakBetweenGames = TournamentValidator.getBreakBetweenGames(scanner);
        int ceremonyTime = TournamentValidator.getCeremonyTime(scanner);
        TournamentStatus status = TournamentValidator.getTournamentStatus(scanner);

        boolean success = tournamentService.addTournament(
                title, startDate, endDate, numberOfSpectators, estimatedDuration,
                breakBetweenGames, ceremonyTime, status, game
        );
        System.out.println(success ? "Tournament created successfully." : "Tournament creation failed.");
    }

    private void updateTournament() {
        Long tournamentId = TournamentValidator.getTournamentId(scanner);
        String updatedTitle = TournamentValidator.getTournamentTitle(scanner);
        LocalDate updatedStartDate = TournamentValidator.getTournamentStartDate(scanner);
        LocalDate updatedEndDate = TournamentValidator.getTournamentEndDate(scanner);
        int updatedNumberOfSpectators = TournamentValidator.getNumberOfSpectators(scanner);
        int updatedEstimatedDuration = TournamentValidator.getEstimatedDuration(scanner);
        int updatedBreakBetweenGames = TournamentValidator.getBreakBetweenGames(scanner);
        int updatedCeremonyTime = TournamentValidator.getCeremonyTime(scanner);
        TournamentStatus updatedStatus = TournamentValidator.getTournamentStatus(scanner);

        boolean success = tournamentService.updateTournament(tournamentId, updatedTitle, updatedStartDate, updatedEndDate, updatedNumberOfSpectators, updatedEstimatedDuration, updatedBreakBetweenGames, updatedCeremonyTime, updatedStatus);
        System.out.println(success ? "Tournament updated successfully." : "Tournament update failed.");
    }

    private void addTeamToTournament() {
        Long tournamentId = TournamentValidator.getTournamentId(scanner);
        Long teamId = TeamValidator.getTeamId(scanner);

        Team team = teamService.getTeam(teamId);

        if (team == null) {
            System.out.println("Team with the specified ID does not exist.");
            return;
        }

        boolean success = tournamentService.addTeamToTournament(tournamentId, team);
        System.out.println(success ? "Team added to tournament successfully." : "Failed to add team to tournament.");
    }

    private void removeTeamFromTournament() {
        Long tournamentId = TournamentValidator.getTournamentId(scanner);
        Long teamId = TeamValidator.getTeamId(scanner);

        Team team = teamService.getTeam(teamId);

        if (team == null) {
            System.out.println("Team with the specified ID does not exist.");
            return;
        }

        boolean success = tournamentService.removeTeamFromTournament(tournamentId, team);
        System.out.println(success ? "Team removed from tournament successfully." : "Failed to remove team from tournament.");
    }

    private void calculateEstimatedDuration() {
        Long tournamentId = TournamentValidator.getTournamentId(scanner);
        int estimatedDurationMinutes = tournamentService.getEstimatedDuration(tournamentId);
        int hours = estimatedDurationMinutes / 60;
        int minutes = estimatedDurationMinutes % 60;

        System.out.println("Estimated Tournament Duration: " + estimatedDurationMinutes + " minutes (" + hours + " hours and " + minutes + " minutes).");
    }

    private void viewAllTournaments() {
        List<Tournament> tournaments = tournamentService.getTournaments();
        if (tournaments.isEmpty()) {
            System.out.println("No tournaments available.");
        } else {
            for (Tournament tournament : tournaments) {
                tournament.showDetails();
                System.out.println("-----------");
            }
        }
    }

    private void createGame() {
        String name = GameValidator.getGameName(scanner);
        int difficulty = GameValidator.getDifficulty(scanner);
        int averageDuration = GameValidator.getAverageDuration(scanner);

        boolean success = gameService.addGame(name, difficulty, averageDuration);
        System.out.println(success ? "Game created successfully." : "Game creation failed.");
    }

    private void updateGame() {
        Long gameId = GameValidator.getGameId(scanner);
        String name = GameValidator.getGameName(scanner);
        int difficulty = GameValidator.getDifficulty(scanner);
        int averageDuration = GameValidator.getAverageDuration(scanner);

        boolean success = gameService.updateGame(gameId, name, difficulty, averageDuration);
        System.out.println(success ? "Game updated successfully." : "Game update failed.");
    }

    private void viewAllGames() {
        List<Game> games = gameService.getAllGames();
        if (games.isEmpty()) {
            System.out.println("No games available.");
        } else {
            for (Game game : games) {
                game.showDetails();
                System.out.println("-----------");
            }
        }
    }
}