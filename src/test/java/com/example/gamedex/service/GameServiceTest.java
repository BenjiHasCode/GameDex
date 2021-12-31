package com.example.gamedex.service;

import com.example.gamedex.GameDexApplication;

import com.example.gamedex.model.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;

import javax.inject.Inject;


import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = GameDexApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GameServiceTest {
    @Container
    public static GenericContainer<?> postGis = new GenericContainer<>("postgis/postgis:12-3.1-alpine")
            .withExposedPorts(5432)
            .withEnv("POSTGRES_DB", "GAMEDEX")
            .withEnv("POSTGRES_USER", "test")
            .withEnv("POSTGRES_PASSWORD", "test");

    @Inject
    private GameService gameService;
    @LocalServerPort
    int randomServerPort;

    @BeforeAll
    static void setUpBeforeClass() {
        assertNotNull(postGis);
        postGis.start();
        System.out.println(postGis.getFirstMappedPort());
        System.setProperty("spring.datasource.jdbcUrl",
                "jdbc:postgresql://localhost:" + postGis.getFirstMappedPort() + "/GAMEDEX");
        System.setProperty("hibernate.show_sql", "true");
        System.setProperty("hibernate.format_sql", "true");
        System.setProperty("spring.liquibase.contexts", "default");
    }

    @Test
    void shouldNotFailWhenInjected() {
        assertNotNull(gameService);
    }

    @Test
    public void findTest() {
        Game game = gameService.find(1);

        assertNotNull(game);
        assertEquals(1, game.getId());

        // mock
    }

    @Test
    public void findAllTest() {
        String name = "Grand Theft Auto";
        int page = 1;

        Set<Game> games = gameService.findAll(name, page);

        assertNotNull(games);
        assertNotEquals(0, games.size());
    }

    @Test
    public void findAllByGenreTest() {
        long id = 1;
        int page = 1;

        Set<Game> games = gameService.findAllByGenre(id, page);

        assertNotNull(games);
        assertNotEquals(0, games.size());

        // assert that all games have the genre
        for (Game game: games) {
            boolean hasGenre = false;
            for (Genre genre: game.getGenres()) {
                if (genre.getId() == id) {
                    hasGenre = true;
                    break;
                }
            }
            assertTrue(hasGenre);
        }
    }

    @Test
    public void findAllByTagTest() {
        long id = 1;
        int page = 1;

        Set<Game> games = gameService.findAllByTag(id, page);

        assertNotNull(games);
        assertNotEquals(0, games.size());

        // assert that all games have the tag
        for (Game game: games) {
            boolean hasTag = false;
            for (Tag tag: game.getTags()) {
                if (tag.getId() == id) {
                    hasTag = true;
                    break;
                }
            }
            assertTrue(hasTag);
        }
    }

    @Test
    public void findAllByDeveloperTest() {
        long id = 1612;
        int page = 1;

        Set<Game> games = gameService.findAllByDeveloper(id, page);

        assertNotNull(games);
        assertNotEquals(0, games.size());
    }

    @Test
    public void findAllByPlatform() {
        long id = 1;
        int page = 1;

        Set<Game> games = gameService.findAllByPlatform(id, page);

        assertNotNull(games);
        assertNotEquals(0, games.size());

        // assert that all games have the developer
        for (Game game: games) {
            boolean hasPlatform = false;
            for (Platform platform: game.getPlatforms()) {
                if (platform.getId() == id) {
                    hasPlatform = true;
                    break;
                }
            }
            assertTrue(hasPlatform);
        }

        assertEquals(24, games.size());
    }
}
