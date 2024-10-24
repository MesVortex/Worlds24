package org.esports.Repository.Interface;

import org.esports.Model.Game;
import java.util.List;

public interface GameRepository {
    void save(Game game);
    Game findById(Long id);
    List<Game> findAll();
    void update(Game game);
    void delete(Long id);
}
