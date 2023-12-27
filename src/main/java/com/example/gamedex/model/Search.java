package com.example.gamedex.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter @Setter
@NoArgsConstructor
public class Search {
    private int count;
    private String next;
    private String previous;
    private Set<Game> results;
}
