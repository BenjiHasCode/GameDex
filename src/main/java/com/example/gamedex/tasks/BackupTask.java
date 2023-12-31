package com.example.gamedex.tasks;

import com.example.gamedex.model.Game;
import com.example.gamedex.repository.GameRepository;

import java.util.HashSet;
import java.util.Set;


public class BackupTask implements Runnable {
    private final Set<Game> games;
    private final GameRepository gameRepository;

    public BackupTask(Game game, GameRepository gameRepository) {
        this.gameRepository = gameRepository;
        this.games = new HashSet<>();
        this.games.add(game);
    }

    public BackupTask(Set<Game> games, GameRepository gameRepository) {
        this.games = games;
        this.gameRepository = gameRepository;
    }

    public void run() {
        gameRepository.saveAll(this.games);
    }
}
