package org.esports.Service;

import org.esports.Model.Player;
import org.esports.Repository.Interface.PlayerRepository;

import java.util.List;

public class PlayerService {
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
        player = playerRepository.getPlayer(playerId);

        if (player == null) {
            System.out.println("Player not found!");
            return false;
        }

        player.setNickname(name);
        player.setAge(age);

        return playerRepository.updatePlayer(player);
    }


    public boolean deletePlayer(Long playerId) {
        player = playerRepository.getPlayer(playerId);

        if (player == null) {
            System.out.println("Player not found!");
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
