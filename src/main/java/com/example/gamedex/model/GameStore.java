package com.example.gamedex.model;

import javax.persistence.*;

@Entity
@Table(name = "GAME_STORE")
public class GameStore {
    @Id
    @Column(name = "GAME_STORE_ID")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "GAME_ID")
    private Game game;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "STORE_ID")
    private Store store;

    @Column(name = "URL")
    private String url;

    public GameStore() {
    }

    public GameStore(Long id, Game game, Store store, String url) {
        this.id = id;
        this.game = game;
        this.store = store;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
