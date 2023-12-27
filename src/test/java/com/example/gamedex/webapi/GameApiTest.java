package com.example.gamedex.webapi;

import com.example.gamedex.GameDexApplication;
import com.example.gamedex.model.Game;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = GameDexApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GameApiTest {
    @Inject
    private GameApi gameApi;

    @Test
    public void findByIdTest() {
        Response response = gameApi.findById(1);
        Game game = (Game) response.getEntity();
        assertNotNull(game);
        assertNotNull(response);
        assertEquals(200, response.getStatus());
    }


    @Test
    public void findAllTest() {
        // Arrange
        String name = "Grand Theft Auto";
        int page = 1;

        // Act
        Response response = gameApi.findAll(name, page);

        // Assert
        assertNotNull(response);
        assertEquals(200, response.getStatus());
    }

    @Test
    public void findAllByGenreTest() {
        // Arrange
        long id = 1;
        int page = 1;

        // Act
        Response response = gameApi.findAllByGenre(id, page);

        // Assert
        assertNotNull(response);
        assertEquals(200, response.getStatus());
    }

    @Test
    public void findAllByTagTest() {
        // Arrange
        long id = 1;
        int page = 1;

        // Act
        Response response = gameApi.findAllByTag(id, page);

        // Assert
        assertNotNull(response);
        assertEquals(200, response.getStatus());
    }

    @Test
    public void findAllByDeveloperTest() {
        // Arrange
        long id = 1;
        int page = 1;

        // Act
        Response response = gameApi.findAllByDeveloper(id, page);

        // Assert
        assertNotNull(response);
        assertEquals(200, response.getStatus());
    }

    @Test
    public void findAllByPlatformTest() {
        // Arrange
        long id = 1;
        int page = 1;

        // Act
        Response response = gameApi.findAllByPlatform(id, page);

        // Assert
        assertNotNull(response);
        assertEquals(200, response.getStatus());
    }
}
