package com.juarodriguezc.api.requestModels;

import java.util.ArrayList;
import java.util.List;

public class EpisodeAPI {
    private Long id;
    private String name;
    private List<String> characters = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCharacters() {
        return characters;
    }

    public void setCharacters(List<String> characters) {
        this.characters = characters;
    }

}

