package com.gametracker.gametracker_backend.controller;

import com.gametracker.gametracker_backend.model.Game;
import com.gametracker.gametracker_backend.repository.GameRepository;
import com.gametracker.gametracker_backend.service.GameService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController


@RequestMapping("/api/games")

@CrossOrigin(origins = "*")

public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public List<Game> getAllGames() {
        return gameService.getAllGames();
    }
    @PostMapping
    public Game createGame(@Valid@RequestBody Game game) {
        return gameService.saveGame(game);
    }
    @DeleteMapping("/{id}")
    public void delGame(@PathVariable Long id){
        gameService.deleteGame(id);
    }


    @PutMapping("/{id}")
    public void updateGame(@Valid@PathVariable Long id, @RequestBody Game updatedGame) {
        gameService.updateGame(id, updatedGame);
    }
}
