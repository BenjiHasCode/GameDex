package com.example.gamedex.tasks;

import com.example.gamedex.model.Game;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.Set;

public class SearchSyncTask implements Runnable{
    private final Set<Game> games;

    public SearchSyncTask(Game game) {
        this.games = new HashSet<>();
        this.games.add(game);
    }

    public SearchSyncTask(Set<Game> games) {
        this.games = games;
    }

    public void run() {
        RestTemplate restTemplate = new RestTemplate();
        String uri = "http://localhost:8001/games/populate";
        try {
            restTemplate.postForEntity(uri, games, String.class);
        } catch (RestClientException e) {
            System.err.println(e.getMessage());
        }
    }
}
