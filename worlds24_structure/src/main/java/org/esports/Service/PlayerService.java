package org.esports.Service;

import org.esports.Model.Player;
import org.esports.Repository.Interface.PlayerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PlayerService {
    private static final Logger logger = LoggerFactory.getLogger(PlayerService.class);
    private final PlayerRepository playerRepository;
    private Player player;

    public PlayerService(PlayerRepository playerRepository, Player player) {
        this.playerRepository = playerRepository;
        this.player = player;
    }

    public boolean addPlayer(String name, int age) {
        player.setNickname(name);
        player.setAge(age);
        return playerRepository.addPlayer(player);
    }

    public boolean updatePlayer(Long playerId, String name, int age) {
        Player existingPlayer = playerRepository.getPlayer(playerId);

        if (existingPlayer == null) {
            logger.warn("Player with ID {} not found!", playerId);
            return false;
        }

        existingPlayer.setNickname(name);
        existingPlayer.setAge(age);
        return playerRepository.updatePlayer(existingPlayer);
    }

    public boolean deletePlayer(Long playerId) {
        Player existingPlayer = playerRepository.getPlayer(playerId);

        if (existingPlayer == null) {
            logger.warn("Player with ID {} not found!", playerId);
            return false;
        }

        return playerRepository.deletePlayer(playerId);
    }

    public Player getPlayer(Long id) {
        return playerRepository.getPlayer(id);
    }

    public List<Player> getPlayers() {
        return playerRepository.getPlayers();
    }
}
