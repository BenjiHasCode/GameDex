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
    @Container
    public static GenericContainer<?> postGis = new GenericContainer<>("postgis/postgis:12-3.1-alpine")
            .withExposedPorts(5432)
            .withEnv("POSTGRES_DB", "GAMEDEX")
            .withEnv("POSTGRES_USER", "test")
            .withEnv("POSTGRES_PASSWORD", "test");

    @Inject
    private GameApi gameApi;
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
        assertNotNull(gameApi);
    }

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
        String name = "Grand Theft Auto";
        int page = 1;

        Response response = gameApi.findAll(name, page);
        assertNotNull(response);
        assertEquals(200, response.getStatus());
    }

    @Test
    public void findAllByGenreTest() {
        long id = 1;
        int page = 1;

        Response response = gameApi.findAllByGenre(id, page);
        assertNotNull(response);
        assertEquals(200, response.getStatus());
    }

    @Test
    public void findAllByTagTest() {
        long id = 1;
        int page = 1;

        Response response = gameApi.findAllByTag(id, page);
        assertNotNull(response);
        assertEquals(200, response.getStatus());

    }

    @Test
    public void findAllByDeveloperTest() {
        long id = 1;
        int page = 1;

        Response response = gameApi.findAllByDeveloper(id, page);
        assertNotNull(response);
        assertEquals(200, response.getStatus());
    }

    @Test
    public void findAllByPlatformTest() {
        long id = 1;
        int page = 1;

        Response response = gameApi.findAllByPlatform(id, page);
        assertNotNull(response);
        assertEquals(200, response.getStatus());
    }
}
