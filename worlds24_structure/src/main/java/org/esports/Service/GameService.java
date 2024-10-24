package org.esports.Service;

import org.esports.Model.Game;
import org.esports.Repository.Interface.GameRepository;

import java.util.List;

public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public void addGame(Game game) {
        gameRepository.save(game);
    }

    public Game getGame(Long id) {
        return gameRepository.findById(id);
    }

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public void updateGame(Game game) {
        gameRepository.update(game);
    }

    public void removeGame(Long id) {
        gameRepository.delete(id);
    }
}
