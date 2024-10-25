package org.esports.Service;

import org.esports.Model.Game;
import org.esports.Repository.Interface.GameRepository;

import java.util.List;

public class GameService {

    private final GameRepository gameRepository;
    private Game game;

    public GameService(GameRepository gameRepository, Game game) {
        this.gameRepository = gameRepository;
        this.game = game;
    }

    public boolean addGame(String name, int difficulty, int averageDuration) {
        game.setName(name);
        game.setDifficulty(difficulty);
        game.setAverageDuration(averageDuration);

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
