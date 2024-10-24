package org.esports.Service;

import org.esports.Model.Tournament;
import org.esports.Repository.Interface.TournamentRepository;

import java.util.List;

public class TournamentService {
    private final TournamentRepository tournamentRepository;

    // Constructor for dependency injection
    public TournamentService(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }

    public void addTournament(Tournament tournament) {
        tournamentRepository.addTournament(tournament);
    }

    public void updateTournament(Tournament tournament) {
        tournamentRepository.updateTournament(tournament);
    }

    public void deleteTournament(Long id) {
        tournamentRepository.deleteTournament(id);
    }

    public Tournament getTournament(Long id) {
        return tournamentRepository.getTournament(id);
    }

    public List<Tournament> getTournaments() {
        return tournamentRepository.getTournaments();
    }
}
