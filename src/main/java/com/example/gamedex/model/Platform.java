package com.example.gamedex.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.IOException;
import java.util.Set;

@Entity
@Table(name = "PLATFORM")
@JsonDeserialize(using = Platform.Deserializer.class)
@Getter @Setter
@NoArgsConstructor
public class Platform {
    @Id
    @Column(name = "PLATFORM_ID")
    private Long id;
    @Column(name = "NAME")
    private String name;

    @ManyToMany(mappedBy = "platforms")
    @JsonIgnore
    private Set<Game> games;

    // This can be fazed out with the external api
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
