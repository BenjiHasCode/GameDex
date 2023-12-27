package com.example.gamedex.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "DEVELOPER")
@Getter @Setter
@NoArgsConstructor
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
