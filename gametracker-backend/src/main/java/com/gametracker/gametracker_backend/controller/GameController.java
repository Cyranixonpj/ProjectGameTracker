package com.gametracker.gametracker_backend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController


@RequestMapping("/api/games")

@CrossOrigin(origins = "*")
// BEZPIECZEŃSTWO (CORS): Przeglądarki internetowe blokują sytuację, w której skrypt z jednej domeny (np. Angular z localhost:4200) próbuje pobrać dane z innej domeny (np. Spring z localhost:8080). To mechanizm obronny Same-Origin Policy.
// Adnotacja @CrossOrigin wysyła w nagłówku odpowiedzi HTTP pole "Access-Control-Allow-Origin: *", mówiąc przeglądarce: "Pozwalam na ten ruch".
// Jako przyszły DevSecOps musisz wiedzieć, że gwiazdka (*) oznacza "pozwól każdemu na świecie" – na tym etapie to dopuszczalne, ale na produkcji to krytyczny błąd bezpieczeństwa. Zmienimy to później.
public class GameController {

    @GetMapping("/mgs")
    // INŻYNIERIA: Mapujemy konkretną metodę HTTP GET na podścieżkę /mgs. Full URL to: http://localhost:8080/api/games/mgs
    public Map<String, Object> getMGSInfo() {
        // Zwracamy strukturę Map (klucz-wartość), imitując dane, które docelowo wyciągniemy z bazy PostgreSQL
        return Map.of(
                "title", "Metal Gear Solid",
                "developer", "Konami",
                "rating", 9.5,
                "review", "Absolutne arcydzieło Hideo Kojimy. Klasyka gatunku stealth-action."
        );
    }
}
