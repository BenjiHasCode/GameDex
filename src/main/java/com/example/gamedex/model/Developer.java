package com.example.gamedex.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "DEVELOPER")
@Data
public class Developer {
    @Id
    @Column(name = "DEVELOPER_ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToMany(mappedBy = "developers")
    @JsonIgnore
    private Set<Game> games;
}
