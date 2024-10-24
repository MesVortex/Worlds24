package org.esports.Service;

import org.esports.Model.Player;
import org.esports.Repository.Interface.PlayerRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class PlayerService {
    private final PlayerRepository playerRepository;
    private final Player player;

    public PlayerService(PlayerRepository playerRepository, Player player) {
        this.playerRepository = playerRepository;
        this.player = player;
    }

    public boolean addPlayer(String name, int age) {

        player.setNickname(name);
        player.setAge(age);

        return playerRepository.addPlayer(player);
    }


    public boolean updatePlayer(Player player) {
        return playerRepository.updatePlayer(player);
    }

    public boolean deletePlayer(Long id) {
        return playerRepository.deletePlayer(id);
    }

    public Player getPlayer(Long id) {
        return playerRepository.getPlayer(id);
    }

    public List<Player> getPlayers() {
        return playerRepository.getPlayers();
    }

}
