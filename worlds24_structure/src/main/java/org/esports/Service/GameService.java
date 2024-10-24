package org.esports.Service;

import org.esports.Model.Game;
import org.esports.Repository.Interface.GameRepository;

import java.util.List;

public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public boolean addGame(Game game) {
        return gameRepository.save(game);
    }

    public Game getGame(Long id) {
        return gameRepository.findById(id);
    }

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public boolean updateGame(Game game) {
        return gameRepository.update(game);
    }

    public boolean removeGame(Long id) {
        return gameRepository.delete(id);
    }

}
