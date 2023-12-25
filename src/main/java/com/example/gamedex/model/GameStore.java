package com.example.gamedex.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "GAME_STORE")
@Data
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
}
