package com.example.gamedex.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "SCREENSHOT")
@Data
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
}
