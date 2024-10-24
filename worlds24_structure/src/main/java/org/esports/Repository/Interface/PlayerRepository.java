package org.esports.Repository.Interface;

import org.esports.Model.Player;
import java.util.List;

public interface PlayerRepository {
    boolean addPlayer(Player player);
    boolean updatePlayer(Player player);
    boolean deletePlayer(Long id);
    Player getPlayer(Long id);
    List<Player> getPlayers();
}
