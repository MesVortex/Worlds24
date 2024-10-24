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

    public boolean addTournament(Tournament tournament) {
        return tournamentRepository.addTournament(tournament);
    }

    public boolean updateTournament(Tournament tournament) {
        return tournamentRepository.updateTournament(tournament);
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
