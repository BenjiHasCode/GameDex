package com.example.gamedex.service;

import com.example.gamedex.model.Game;
import com.example.gamedex.model.Genre;
import com.example.gamedex.model.Platform;
import com.example.gamedex.model.Tag;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

import javax.inject.Inject;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GameServiceTest {
    @Inject
    private GameService gameService;

    @Test
    public void findTest() {
        // Arrange
        long id = 1;
        long expected = 1;

        // Act
        Game game = gameService.find(id);

        // Assert
        assertEquals(expected, game.getId());
    }

    @Test
    public void findAllByGenreTest() {
        // Arrange
        long id = 1;
        int page = 1;
        int unexpected = 0;

        // Act
        Set<Game> games = gameService.findAllByGenre(id, page);

        // Assert
        assertNotEquals(unexpected, games.size());

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
        // Arrange
        long id = 1;
        int page = 1;
        int unexpected = 0;

        // Act
        Set<Game> games = gameService.findAllByTag(id, page);

        // Assert
        assertNotEquals(unexpected, games.size());

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
        // Arrange
        long id = 1612;
        int page = 1;
        int unexpected = 0;

        // Act
        Set<Game> games = gameService.findAllByDeveloper(id, page);

        // Assert
        assertNotEquals(unexpected, games.size());
    }

    @Test
    public void findAllByPlatform() {
        // Arrange
        long id = 1;
        int page = 1;
        int unexpected = 0;

        // Act
        Set<Game> games = gameService.findAllByPlatform(id, page);

        // Assert
        assertNotEquals(unexpected, games.size());

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
    }
}
