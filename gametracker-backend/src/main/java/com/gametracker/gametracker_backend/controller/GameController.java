package com.gametracker.gametracker_backend.controller;

import com.gametracker.gametracker_backend.model.Game;
import com.gametracker.gametracker_backend.repository.GameRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController


@RequestMapping("/api/games")

@CrossOrigin(origins = "*")
// BEZPIECZEŃSTWO (CORS): Przeglądarki internetowe blokują sytuację, w której skrypt z jednej domeny (np. Angular z localhost:4200) próbuje pobrać dane z innej domeny (np. Spring z localhost:8080). To mechanizm obronny Same-Origin Policy.
// Adnotacja @CrossOrigin wysyła w nagłówku odpowiedzi HTTP pole "Access-Control-Allow-Origin: *", mówiąc przeglądarce: "Pozwalam na ten ruch".
// Jako przyszły DevSecOps musisz wiedzieć, że gwiazdka (*) oznacza "pozwól każdemu na świecie" – na tym etapie to dopuszczalne, ale na produkcji to krytyczny błąd bezpieczeństwa. Zmienimy to później.
public class GameController {

    private final GameRepository gameRepository;

    public GameController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @GetMapping
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }
}
