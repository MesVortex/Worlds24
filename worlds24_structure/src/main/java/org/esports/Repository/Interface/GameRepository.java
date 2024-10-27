package org.esports.Repository.Interface;

import org.esports.Model.Game;
import java.util.List;

public interface GameRepository {
    boolean save(Game game);
    Game findById(Long id);
    List<Game> findAll();
    boolean update(Game game);
}
