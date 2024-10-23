package org.esports.Service;

import org.esports.Repository.Interface.TournamentRepository;

public class TournamentService {
    private final TournamentRepository TournamentRepository;

    public TournamentService(TournamentRepository TournamentRepository) {
        this.TournamentRepository = TournamentRepository;
    }
}
