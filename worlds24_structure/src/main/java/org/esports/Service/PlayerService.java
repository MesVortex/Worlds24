package org.esports.Service;

import org.esports.Repository.Interface.PlayerRepository;

public class PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }
}
