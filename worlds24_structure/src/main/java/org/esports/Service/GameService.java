package org.esports.Service;

import org.esports.Repository.Interface.GameRepository;

public class GameService {
    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }
}
