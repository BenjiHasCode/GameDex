package com.example.gamedex.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
public class Search {
    private int count;
    private String next;
    private String previous;
    private Set<Game> results;
}
