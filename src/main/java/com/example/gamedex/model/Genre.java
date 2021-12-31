package com.example.gamedex.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "GENRE")
public class Genre {
    @Id
    @Column(name = "GENRE_ID")
    private Long id;
    @Column(name = "NAME")
    private String name;

    @ManyToMany(mappedBy = "genres")
    @JsonIgnore
    private Set<Game> games;

    public Genre() {
    }

    public Genre(Long id, String name, Set<Game> games) {
        this.id = id;
        this.name = name;
        this.games = games;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }
}
