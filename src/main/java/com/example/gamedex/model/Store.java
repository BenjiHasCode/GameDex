package com.example.gamedex.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "STORE")
@Getter @Setter
@NoArgsConstructor
public class Store {
    @Id
    @Column(name = "STORE_ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DOMAIN")
    private String domain;
    @Column(name = "GAMES_COUNT")
    private int games_count;
    @Column(name = "DESCRIPTION")
    private String description;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    @JsonIgnore
    Set<GameStore> games;
}
