package com.gametracker.gametracker_backend.service;

import com.gametracker.gametracker_backend.exception.GameNotFoundException;
import com.gametracker.gametracker_backend.model.Game;
import com.gametracker.gametracker_backend.repository.GameRepository;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GameService {

    private final GameRepository gameRepository;


    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public Game saveGame(Game game) {

        return gameRepository.save(game);
    }

    public void deleteGame(Long id) {
        gameRepository.deleteById(id);
    }

    public void updateGame(Long id, Game updatedGame) {
        Game existingGame = gameRepository.findById(id)
                .orElseThrow(() -> new GameNotFoundException(id));

        existingGame.setTitle(updatedGame.getTitle());
        existingGame.setDeveloper(updatedGame.getDeveloper());
        existingGame.setRating(updatedGame.getRating());
        existingGame.setReview(updatedGame.getReview());

        gameRepository.save(existingGame);
    }
}
