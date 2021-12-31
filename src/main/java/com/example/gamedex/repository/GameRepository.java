package com.example.gamedex.repository;

import com.example.gamedex.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface GameRepository extends JpaRepository<Game, Long> {
    @Query("FROM Game g LEFT JOIN FETCH g.screenshots LEFT JOIN FETCH g.publishers JOIN FETCH g.developers LEFT JOIN FETCH g.tags LEFT JOIN FETCH g.genres LEFT JOIN FETCH g.stores LEFT JOIN FETCH g.platforms WHERE g.id = :id")
    Game fetch(Long id);

    @Query("FROM Game g LEFT JOIN FETCH g.screenshots LEFT JOIN FETCH g.publishers JOIN FETCH g.developers LEFT JOIN FETCH g.tags LEFT JOIN FETCH g.genres LEFT JOIN FETCH g.stores LEFT JOIN FETCH g.platforms " +
            "WHERE LOWER(g.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    Set<Game> findAllByName(String name);

    @Query("FROM Game g LEFT JOIN FETCH g.screenshots LEFT JOIN FETCH g.publishers JOIN FETCH g.developers LEFT JOIN FETCH g.tags t LEFT JOIN FETCH g.genres LEFT JOIN FETCH g.stores LEFT JOIN FETCH g.platforms " +
            "WHERE t.id = :id")
    Set<Game> findAllByTag(Long id);

    @Query("FROM Game g LEFT JOIN FETCH g.screenshots LEFT JOIN FETCH g.publishers JOIN FETCH g.developers LEFT JOIN FETCH g.tags LEFT JOIN FETCH g.genres ge LEFT JOIN FETCH g.stores LEFT JOIN FETCH g.platforms " +
            "WHERE ge.id = :id")
    Set<Game> findAllByGenre(Long id);

    @Query("FROM Game g LEFT JOIN FETCH g.screenshots LEFT JOIN FETCH g.publishers JOIN FETCH g.developers d LEFT JOIN FETCH g.tags LEFT JOIN FETCH g.genres LEFT JOIN FETCH g.stores LEFT JOIN FETCH g.platforms " +
            "WHERE d.id = :id")
    Set<Game> findAllByDeveloper(Long id);

    @Query("FROM Game g LEFT JOIN FETCH g.screenshots LEFT JOIN FETCH g.publishers JOIN FETCH g.developers LEFT JOIN FETCH g.tags LEFT JOIN FETCH g.genres LEFT JOIN FETCH g.stores LEFT JOIN FETCH g.platforms p " +
            "WHERE p.id = :id")
    Set<Game> findAllByPlatform(Long id);
}