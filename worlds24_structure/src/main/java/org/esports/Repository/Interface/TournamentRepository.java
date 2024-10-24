package org.esports.Repository.Interface;

import org.esports.Model.Tournament;
import java.util.List;

public interface TournamentRepository {
    void addTournament(Tournament tournament);
    void updateTournament(Tournament tournament);
    void deleteTournament(Long id);
    Tournament getTournament(Long id);
    List<Tournament> getTournaments();
}
