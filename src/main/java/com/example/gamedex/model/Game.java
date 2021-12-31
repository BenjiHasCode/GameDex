package com.example.gamedex.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "GAME")
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


    public Game() {
    }

    public Game(Long id, String name, String description, int metacritic, String background_image, String released,
                int playtime, Set<Screenshot> screenshots, Set<Publisher> publishers, Set<Developer> developers,
                Set<Tag> tags, Set<Genre> genres, Set<GameStore> stores, Set<Platform> platforms) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.metacritic = metacritic;
        this.background_image = background_image;
        this.released = released;
        this.playtime = playtime;
        this.screenshots = screenshots;
        this.publishers = publishers;
        this.developers = developers;
        this.tags = tags;
        this.genres = genres;
        this.stores = stores;
        this.platforms = platforms;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMetacritic() {
        return metacritic;
    }

    public void setMetacritic(int metacritic) {
        this.metacritic = metacritic;
    }

    public String getBackground_image() {
        return background_image;
    }

    public void setBackground_image(String imageUrl) {
        this.background_image = imageUrl;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public int getPlaytime() {
        return playtime;
    }

    public void setPlaytime(int playtime) {
        this.playtime = playtime;
    }

    public Set<Screenshot> getScreenshots() {
        return screenshots;
    }

    public void setScreenshots(Set<Screenshot> screenshots) {
        this.screenshots = screenshots;
    }

    public Set<Publisher> getPublisher() {
        return publishers;
    }

    public void setPublisher(Set<Publisher> publisher) {
        this.publishers = publisher;
    }

    public Set<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(Set<Developer> developers) {
        this.developers = developers;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public Set<GameStore> getStores() {
        return stores;
    }

    public void setStores(Set<GameStore> stores) {
        this.stores = stores;
    }

    public Set<Platform> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(Set<Platform> platforms) {
        this.platforms = platforms;
    }
}
