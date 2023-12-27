package com.example.gamedex.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "TAG")
@Getter @Setter
@NoArgsConstructor
public class Tag {
    @Id
    @Column(name = "TAG_ID")
    private Long id;
    @Column(name = "NAME")
    private String name;

    @ManyToMany(mappedBy = "tags")
    @JsonIgnore
    private Set<Game> games;
}
