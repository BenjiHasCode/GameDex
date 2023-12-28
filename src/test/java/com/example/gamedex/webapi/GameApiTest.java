package com.example.gamedex.webapi;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GameApiTest {
    @Inject
    private GameApi gameApi;

    //-------------------UNIT--------------------//

    //----------------INTEGRATION----------------//
    // method for our parameterized tests
    private static Stream<Arguments> expectedReturnCodesBasedOnId() {
        return Stream.of(
                arguments(1, 200),
                arguments(-999, 404)
        );
    }
    @ParameterizedTest
    @MethodSource("expectedReturnCodesBasedOnId")
    public void findByIdTest(long id, int expected) {
        // Act
        Response response = gameApi.findById(id);

        // Assert
        assertEquals(expected, response.getStatus());
    }

    @ParameterizedTest
    @MethodSource("expectedReturnCodesBasedOnId")
    public void findAllByGenreTest(long id, int expected) {
        // Arrange
        int page = 1;

        // Act
        Response response = gameApi.findAllByGenre(id, page);

        // Assert
        assertEquals(expected, response.getStatus());
    }

    @ParameterizedTest
    @MethodSource("expectedReturnCodesBasedOnId")
    public void findAllByTagTest(long id, int expected) {
        // Arrange
        int page = 1;

        // Act
        Response response = gameApi.findAllByTag(id, page);

        // Assert
        assertEquals(expected, response.getStatus());
    }

    private static Stream<Arguments> devIdAndExpectedCode() {
        return Stream.of(
                arguments(1612, 200),
                arguments(-999, 404)
        );
    }
    @ParameterizedTest
    @MethodSource("devIdAndExpectedCode")
    public void findAllByDeveloperTest(long id, int expected) {
        // Arrange
        int page = 1;

        // Act
        Response response = gameApi.findAllByDeveloper(id, page);

        // Assert
        assertEquals(expected, response.getStatus());
    }

    @ParameterizedTest
    @MethodSource("expectedReturnCodesBasedOnId")
    public void findAllByPlatformTest(long id, int expected) {
        // Arrange
        int page = 1;

        // Act
        Response response = gameApi.findAllByPlatform(id, page);

        // Assert
        assertEquals(expected, response.getStatus());
    }
}
