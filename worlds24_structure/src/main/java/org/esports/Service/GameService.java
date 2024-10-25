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

    public boolean updateGame(Long gameId, String name, int difficulty, int averageDuration) {
        Game existingGame = gameRepository.findById(gameId);
        if (existingGame == null) {
            System.out.println("Game not found!");
            return false;
        }

        existingGame.setName(name);
        existingGame.setDifficulty(difficulty);
        existingGame.setAverageDuration(averageDuration);

        return gameRepository.update(existingGame);
    }

    public boolean removeGame(Long id) {
        return gameRepository.delete(id);
    }

}
