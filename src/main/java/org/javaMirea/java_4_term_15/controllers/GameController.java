package org.javaMirea.java_4_term_15.controllers;

import lombok.RequiredArgsConstructor;
import org.javaMirea.java_4_term_15.entities.Game;
import org.javaMirea.java_4_term_15.services.GameService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/games")
@RequiredArgsConstructor
public class GameController {
    private final GameService gameService;

    @PostMapping
    public Game createGame(@RequestBody Game game) {
        gameService.save(game);
        return game;
    }

    @GetMapping
    public List<Game> getAllGames() {
        return gameService.getGames();
    }

    @DeleteMapping
    public Game deleteGame(@RequestBody Game game) {
        gameService.delete(game);
        return game;
    }
}
