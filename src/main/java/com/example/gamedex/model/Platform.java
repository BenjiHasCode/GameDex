package com.example.gamedex.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.*;
import java.io.IOException;
import java.util.Set;

@Entity
@Table(name = "PLATFORM")
@JsonDeserialize(using = Platform.Deserializer.class)
public class Platform {
    @Id
    @Column(name = "PLATFORM_ID")
    private Long id;
    @Column(name = "NAME")
    private String name;

    @ManyToMany(mappedBy = "platforms")
    @JsonIgnore
    private Set<Game> games;

    public Platform() {
    }

    public Platform(Long id, String name, Set<Game> games) {
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

    static class Deserializer extends JsonDeserializer<Platform> {

        @Override
        public Platform deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            Platform platform = new Platform();
            JsonNode node = jsonParser.readValueAsTree();
            JsonNode p = node.get("platform");
            platform.setId(p.get("id").asLong());
            platform.setName(p.get("name").asText());
            return platform;
        }
    }
}
