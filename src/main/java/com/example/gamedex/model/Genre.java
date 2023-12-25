package com.example.gamedex.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "GENRE")
@Data
public class Genre {
    @Id
    @Column(name = "GENRE_ID")
    private Long id;
    @Column(name = "NAME")
    private String name;

    @ManyToMany(mappedBy = "genres")
    @JsonIgnore
    private Set<Game> games;
}
