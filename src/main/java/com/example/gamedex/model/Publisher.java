package com.example.gamedex.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "PUBLISHER")
@Data
public class Publisher {
    @Id
    @Column(name = "PUBLISHER_ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToMany(mappedBy = "publishers")
    @JsonIgnore
    private Set<Game> games;
}
