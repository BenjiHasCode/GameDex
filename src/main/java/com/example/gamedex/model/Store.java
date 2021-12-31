package com.example.gamedex.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "STORE")
public class Store {
    @Id
    @Column(name = "STORE_ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DOMAIN")
    private String domain;
    @Column(name = "GAMES_COUNT")
    private int games_count;
    @Column(name = "DESCRIPTION")
    private String description;


    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    @JsonIgnore
    Set<GameStore> games;

    public Store() {
    }

    public Store(Long id, String name, String domain, int games_count, String description, String url, Set<GameStore> games) {
        this.id = id;
        this.name = name;
        this.domain = domain;
        this.games_count = games_count;
        this.description = description;
       // this.url = url;
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

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public int getGames_count() {
        return games_count;
    }

    public void setGames_count(int games_count) {
        this.games_count = games_count;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Set<GameStore> getGames() {
        return games;
    }

    public void setGames(Set<GameStore> games) {
        this.games = games;
    }
}
