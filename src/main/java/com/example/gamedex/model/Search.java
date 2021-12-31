package com.example.gamedex.model;

import java.util.Set;

public class Search {
    private int count;
    private String next;
    private String previous;
    private Set<Game> results;

    public Search() {
    }

    public Search(int count, String next, String previous, Set<Game> results) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.results = results;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public Set<Game> getResults() {
        return results;
    }

    public void setResults(Set<Game> results) {
        this.results = results;
    }
}
