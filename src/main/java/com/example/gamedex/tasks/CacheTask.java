package com.example.gamedex.tasks;

import com.example.gamedex.model.Game;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class CacheTask implements Runnable {
    private final Game games;

    public CacheTask(Game game) {
        this.games = game;
    }

    public void run() {
        RestTemplate restTemplate = new RestTemplate();
        String uri = "http://localhost:8002/games";
        try {
            restTemplate.postForEntity(uri, games, String.class);
        } catch (RestClientException e) {
            System.err.println(e.getMessage());
        }
    }
}