package com.juarodriguezc.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.juarodriguezc.api.requestModels.CharacterAPI;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "pcharacter")
public class CharacterModel {
    @JsonIgnore
    @Id
    @Column(unique = true, nullable = false)
    private long id;

    private String name;
    private String species;
    private String gender;
    private String image;


    @JsonIgnore
    @ManyToMany(mappedBy = "characters")
    private Set<EpisodeModel> episodes;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
    private LocationModel location;

    public CharacterModel() {
    }

    public CharacterModel(CharacterAPI character) {
        this.id = character.getId();
        this.name = character.getName();
        this.species = character.getSpecies();
        this.gender = character.getGender();
        this.image = character.getImage();
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

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public Set<EpisodeModel> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Set<EpisodeModel> episodes) {
        this.episodes = episodes;
    }

    public LocationModel getLocation() {
        return location;
    }

    public void setLocation(LocationModel location) {
        this.location = location;
    }
}
