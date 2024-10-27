package org.esports.Service;

import org.esports.Model.Enum.TournamentStatus;
import org.esports.Model.Game;
import org.esports.Model.Team;
import org.esports.Model.Tournament;
import org.esports.Repository.Interface.TournamentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.List;

public class TournamentService {
    private static final Logger logger = LoggerFactory.getLogger(TournamentService.class);
    private final TournamentRepository tournamentRepository;
    private Tournament tournament;

    // Constructor for dependency injection
    public TournamentService(TournamentRepository tournamentRepository, Tournament tournament) {
        this.tournamentRepository = tournamentRepository;
        this.tournament = tournament;
    }

    public boolean addTournament(String title, LocalDate startDate, LocalDate endDate, int numberOfSpectators,
                                 int estimatedDuration, int breakBetweenGames, int ceremonyTime,
                                 TournamentStatus status, Game game) {
        tournament.setTitle(title);
        tournament.setStartDate(startDate);
        tournament.setEndDate(endDate);
        tournament.setNumberOfSpectators(numberOfSpectators);
        tournament.setEstimatedDuration(estimatedDuration);
        tournament.setBreakBetweenGames(breakBetweenGames);
        tournament.setCeremonyTime(ceremonyTime);
        tournament.setStatus(status);
        tournament.setGame(game);

        return tournamentRepository.addTournament(tournament);
    }

    public boolean updateTournament(Long tournamentId, String title, LocalDate startDate, LocalDate endDate,
                                    int numberOfSpectators, int estimatedDuration, int breakBetweenGames,
                                    int ceremonyTime, TournamentStatus status) {
        Tournament existingTournament = tournamentRepository.getTournament(tournamentId);
        if (existingTournament == null) {
            logger.warn("Tournament with ID {} not found!", tournamentId);
            return false;
        }

        existingTournament.setTitle(title);
        existingTournament.setStartDate(startDate);
        existingTournament.setEndDate(endDate);
        existingTournament.setNumberOfSpectators(numberOfSpectators);
        existingTournament.setEstimatedDuration(estimatedDuration);
        existingTournament.setBreakBetweenGames(breakBetweenGames);
        existingTournament.setCeremonyTime(ceremonyTime);
        existingTournament.setStatus(status);

        return tournamentRepository.updateTournament(existingTournament);
    }

    public boolean addTeamToTournament(Long tournamentId, Team team) {
        Tournament tournament = tournamentRepository.getTournament(tournamentId);
        if (tournament == null) {
            logger.warn("Tournament with ID {} not found.", tournamentId);
            return false;
        }

        tournament.getTeams().add(team);
        team.setTournament(tournament);

        return tournamentRepository.updateTournament(tournament);
    }

    public boolean removeTeamFromTournament(Long tournamentId, Team team) {
        Tournament tournament = tournamentRepository.getTournament(tournamentId);
        if (tournament == null) {
            logger.warn("Tournament with ID {} not found.", tournamentId);
            return false;
        }

        if (!tournament.getTeams().remove(team)) {
            logger.warn("Team {} is not part of tournament {}", team.getName(), tournament.getTitle());
            return false;
        }

        team.setTournament(null);

        return tournamentRepository.updateTournament(tournament);
    }

    public Tournament getTournament(Long id) {
        return tournamentRepository.getTournament(id);
    }

    public List<Tournament> getTournaments() {
        return tournamentRepository.getTournaments();
    }

    public int getEstimatedDuration(Long tournamentId) {
        return tournamentRepository.calculateEstimatedDuration(tournamentId);
    }
}