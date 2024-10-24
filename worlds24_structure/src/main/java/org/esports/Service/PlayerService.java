package org.esports.Service;

import org.esports.Model.Player;
import org.esports.Repository.Interface.PlayerRepository;

import java.util.List;

public class PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public void addPlayer(Player player) {
        playerRepository.addPlayer(player);
    }

    public void updatePlayer(Player player) {
        playerRepository.updatePlayer(player);
    }

    public void deletePlayer(Long id) {
        playerRepository.deletePlayer(id);
    }

    public Player getPlayer(Long id) {
        return playerRepository.getPlayer(id);
    }

    public List<Player> getPlayers() {
        return playerRepository.getPlayers();
    }
}
