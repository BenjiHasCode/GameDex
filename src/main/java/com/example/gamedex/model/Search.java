package com.example.gamedex.model;

import lombok.Data;
import java.util.Set;

@Data
public class Search {
    private int count;
    private String next;
    private String previous;
    private Set<Game> results;
}
