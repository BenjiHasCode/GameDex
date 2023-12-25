package com.example.gamedex.model;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "GAME")
@Getter @Setter
@NoArgsConstructor
public class Game {
    @Id
    @Column(name = "GAME_ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DESCRIPTION")
    @JsonAlias("description_raw")
    private String description;
    @Column(name = "METACRITIC")
    private int metacritic;
    @Column(name = "BACKGROUND_IMAGE")
    private String background_image;
    @Column(name = "RELEASED")
    private String released;
    @Column(name = "PLAYTIME")
    private int playtime;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "game")
    @JsonAlias("results")
    private Set<Screenshot> screenshots;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "GAME_PUBLISHER",
            joinColumns = @JoinColumn(name = "GAME_ID"),
            inverseJoinColumns = @JoinColumn(name = "PUBLISHER_ID")
    )
    @JsonAlias("publishers")
    private Set<Publisher> publishers;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "GAME_DEVELOPER",
            joinColumns = @JoinColumn(name = "GAME_ID"),
            inverseJoinColumns = @JoinColumn(name = "DEVELOPER_ID"))
    private Set<Developer> developers;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "GAME_TAG",
            joinColumns = @JoinColumn(name = "GAME_ID"),
            inverseJoinColumns = @JoinColumn(name = "TAG_ID"))
    private Set<Tag> tags;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "GAME_GENRE",
            joinColumns = @JoinColumn(name = "GAME_ID"),
            inverseJoinColumns = @JoinColumn(name = "GENRE_ID"))
    private Set<Genre> genres;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<GameStore> stores;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "GAME_PLATFORM",
            joinColumns = @JoinColumn(name = "GAME_ID"),
            inverseJoinColumns = @JoinColumn(name = "PLATFORM_ID"))
    private Set<Platform> platforms;
}
