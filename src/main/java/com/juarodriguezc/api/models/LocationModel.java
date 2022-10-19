package com.juarodriguezc.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.juarodriguezc.api.requestModels.LocationAPI;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "location")
public class LocationModel {
    @JsonIgnore
    @Id
    @Column(unique = true, nullable = false)
    private long id;


    private String name;
    private String type;
    private String dimension;

    @JsonIgnore
    @OneToMany(mappedBy = "location")
    private Set<CharacterModel> characters = new HashSet<>();

    public LocationModel() {
    }

    public LocationModel(LocationAPI location) {
        this.id = location.getId();
        this.name = location.getName();
        this.type = location.getType();
        this.dimension = location.getDimension();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public Set<CharacterModel> getCharacters() {
        return characters;
    }

    public void setCharacters(Set<CharacterModel> characters) {
        this.characters = characters;
    }
}
