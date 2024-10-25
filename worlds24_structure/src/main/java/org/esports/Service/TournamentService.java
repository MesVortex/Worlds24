package org.esports.Service;

import org.esports.Model.Enum.TournamentStatus;
import org.esports.Model.Tournament;
import org.esports.Repository.Interface.TournamentRepository;

import java.time.LocalDate;
import java.util.List;

public class TournamentService {
    private final TournamentRepository tournamentRepository;
    private Tournament tournament;

    // Constructor for dependency injection
    public TournamentService(TournamentRepository tournamentRepository, Tournament tournament) {
        this.tournamentRepository = tournamentRepository;
        this.tournament = tournament;
    }

    public boolean addTournament(String title, LocalDate startDate, LocalDate endDate, int numberOfSpectators, int estimatedDuration, int breakBetweenGames, int ceremonyTime, TournamentStatus status) {
        tournament.setTitle(title);
        tournament.setStartDate(startDate);
        tournament.setEndDate(endDate);
        tournament.setNumberOfSpectators(numberOfSpectators);
        tournament.setEstimatedDuration(estimatedDuration);
        tournament.setBreakBetweenGames(breakBetweenGames);
        tournament.setCeremonyTime(ceremonyTime);
        tournament.setStatus(status);
        return tournamentRepository.addTournament(tournament);
    }

    public boolean updateTournament(Long tournamentId, String title, LocalDate startDate, LocalDate endDate, int numberOfSpectators, int estimatedDuration, int breakBetweenGames, int ceremonyTime, TournamentStatus status) {
        Tournament existingTournament = tournamentRepository.getTournament(tournamentId);
        if (existingTournament == null) {
            System.out.println("Tournament not found!");
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

    public boolean deleteTournament(Long id) {
        return tournamentRepository.deleteTournament(id);
    }

    public Tournament getTournament(Long id) {
        return tournamentRepository.getTournament(id);
    }

    public List<Tournament> getTournaments() {
        return tournamentRepository.getTournaments();
    }

}
