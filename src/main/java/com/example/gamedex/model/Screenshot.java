package com.example.gamedex.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "SCREENSHOT")
public class Screenshot {
    @Id
    @Column(name = "SCREENSHOT_ID")
    private Long id;

    @Column(name = "URL")
    @JsonAlias("image")
    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GAME_ID")
    @JsonIgnore
    private Game game;

    public Screenshot() {
    }

    public Screenshot(Long id, String url, Game game) {
        this.id = id;
        this.url = url;
        this.game = game;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
