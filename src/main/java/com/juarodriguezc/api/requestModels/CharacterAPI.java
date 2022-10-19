package com.juarodriguezc.api.requestModels;

import java.util.ArrayList;
import java.util.List;

public class CharacterAPI {
    private long id;
    private String name;
    private String species;
    private String gender;
    private String image;
    private LocationResponseAPI location;


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

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocationResponseAPI getLocation() {
        return location;
    }

    public void setLocation(LocationResponseAPI location) {
        this.location = location;
    }
}
