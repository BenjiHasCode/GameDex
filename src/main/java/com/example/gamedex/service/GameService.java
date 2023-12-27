package com.example.gamedex.service;

import com.example.gamedex.model.Game;
import com.example.gamedex.model.Screenshot;
import com.example.gamedex.model.Search;
import com.example.gamedex.repository.GameRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;
import java.util.Set;

@Service
public class GameService {
    private final GameRepository gameRepository;
    private final String url = "https://api.rawg.io/api/games";
    private final String key = "9de4d4ed334b45349c288a628dd2b6ae";

    @Inject
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    // GET
    @Transactional
    public Game find(long id) {
        String uri = url + "/" + id + "?key=" + key;

        // Get response from external api
        RestTemplate restTemplate = new RestTemplate();
        Game result;

        // connect to external api
        try {
            result = restTemplate.getForObject(uri, Game.class);
            Set<Screenshot> screenshots = restTemplate.getForObject(url + "/" + id + "/screenshots?key=" + key, Game.class).getScreenshots();

            if (result != null && screenshots != null) {
                result.setScreenshots(screenshots);

                for(Screenshot s: screenshots) {
                    s.setGame(result);
                }

                //save backup
                gameRepository.save(result);
            }
            // if result is null (external didn't have resource, check local
            else {
                result = gameRepository.fetch(id);
            }
        } catch (Exception e) {
            // fetch backup
            result = gameRepository.fetch(id);
        }

        return result;
    }

    // GET ALL  // remove
    // We find all results with the given name
    public Set<Game> findAll(String name, int page) {
        String uri = url +
                "?key=" + key +
                "&page_size=24&page=" + page +
                "&search=" + name;

        RestTemplate restTemplate = new RestTemplate();
        Set<Game> result;

        try {
            // Get response from external api
            result = restTemplate.getForObject(uri, Search.class).getResults();

            // check local if null
            if (result == null) {
                result = gameRepository.findAllByName(name);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            // fetch backup
            result = gameRepository.findAllByName(name);
        }
        return result;
    }

    public Set<Game> findAllByGenre(Long id, int page) {
        String uri = url + "?key=" + key +
                "&page_size=24&page=" + page +
                "&genres=" + id;

        RestTemplate restTemplate = new RestTemplate();
        Set<Game> result;

        try {
            // Get response from external api
            result = restTemplate.getForObject(uri, Search.class).getResults();

            // if null, fetch backup
            if (result == null) {
                result = gameRepository.findAllByGenre(id); // pages are 0 indexed locally but external api is 1 based
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            // fetch backup
            result = gameRepository.findAllByGenre(id);
        }
        return result;
    }

    public Set<Game> findAllByTag(Long id, int page) {
        String uri = url + "?key=" + key +
                "&page_size=24&page=" + page +
                "&tags=" + id;

        RestTemplate restTemplate = new RestTemplate();
        Set<Game> result;

        try {
            // Get response from external api
            result = restTemplate.getForObject(uri, Search.class).getResults();

            // if null, fetch backup
            if (result == null) {
                result = gameRepository.findAllByTag(id);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            // fetch backup
            result = gameRepository.findAllByTag(id);
        }
        return result;
    }

    public Set<Game> findAllByDeveloper(Long id, int page) {
        String uri = url + "?key=" + key +
                "&page_size=24&page=" + page +
                "&developers=" + id;

        RestTemplate restTemplate = new RestTemplate();
        Set<Game> result;

        try {
            // Get response from external api
            result = restTemplate.getForObject(uri, Search.class).getResults();

            // if null, fetch backup
            if (result == null) {
                result = gameRepository.findAllByDeveloper(id);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            // fetch backup
            result = gameRepository.findAllByDeveloper(id);
        }
        return result;
    }

    public Set<Game> findAllByPlatform(Long id, int page) {
        String uri = url + "?key=" + key +
                "&page_size=24&page=" + page +
                "&platforms=" + id;

        RestTemplate restTemplate = new RestTemplate();
        Set<Game> result = null;

        try {
            // Get response from external api
            Search s = restTemplate.getForObject(uri, Search.class);
            if (s != null) {
                result = restTemplate.getForObject(uri, Search.class).getResults();
            }
            // if null, fetch backup
            if (result == null) {
                result = gameRepository.findAllByPlatform(id);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            // fetch backup
            result = gameRepository.findAllByPlatform(id);
        }
        return result;
    }
}
