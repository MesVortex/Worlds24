package org.esports.Repository.Interface;

import org.esports.Model.Player;
import java.util.List;

public interface PlayerRepository {
    void addPlayer(Player player);
    void updatePlayer(Player player);
    void deletePlayer(Long id);
    Player getPlayer(Long id);
    List<Player> getPlayers();
}
