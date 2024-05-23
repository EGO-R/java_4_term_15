package org.javaMirea.java_4_term_15.controllers;

import lombok.RequiredArgsConstructor;
import org.javaMirea.java_4_term_15.entities.Game;
import org.javaMirea.java_4_term_15.entities.Level;
import org.javaMirea.java_4_term_15.services.LevelService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/levels")
@RequiredArgsConstructor
public class LevelController {
    private final LevelService levelService;


    @PostMapping
    public Level createLevel(@RequestBody Level level) {
        levelService.save(level);
        return level;
    }

    @GetMapping
    public List<Level> getAllLevels() {
        return levelService.getLevels();
    }

    @DeleteMapping
    public Level deleteLevel(@RequestBody Level level) {
        levelService.delete(level);
        return level;
    }
}

