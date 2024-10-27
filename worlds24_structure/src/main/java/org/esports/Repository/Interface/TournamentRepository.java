package org.esports.Repository.Interface;

import org.esports.Model.Tournament;
import java.util.List;

public interface TournamentRepository {
    boolean addTournament(Tournament tournament);
    boolean updateTournament(Tournament tournament);
    boolean deleteTournament(Long id);
    Tournament getTournament(Long id);
    List<Tournament> getTournaments();
    int calculateEstimatedDuration(Long tournamentId);
}
