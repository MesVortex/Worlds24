package org.esports.View;

import org.esports.Service.GameService;
import org.esports.Service.PlayerService;
import org.esports.Service.TeamService;
import org.esports.Service.TournamentService;

public class ConsoleUI {
    private final GameService gameService;
    private final PlayerService playerService;
    private final TeamService teamService;
    private final TournamentService tournamentService;

    public ConsoleUI(GameService gameService, PlayerService playerService, TeamService teamService, TournamentService tournamentService) {
        this.gameService = gameService;
        this.playerService = playerService;
        this.teamService = teamService;
        this.tournamentService = tournamentService;
    }

}
