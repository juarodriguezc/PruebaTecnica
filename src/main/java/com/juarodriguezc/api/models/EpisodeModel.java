package com.juarodriguezc.api.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.juarodriguezc.api.requestModels.EpisodeAPI;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "episode")
public class EpisodeModel {

    @Id
    @Column(unique = true, nullable = false)
    private long episode;

    private String episodeName;

    @ManyToMany
    @JoinTable(
            name = "episode_character",
            joinColumns = @JoinColumn(name = "episode_id"),
            inverseJoinColumns = @JoinColumn(name = "character_id"))
    Set<CharacterModel> characters = new HashSet<>();

    public EpisodeModel() {

    }

    public EpisodeModel(EpisodeAPI episodeAPI) {
        this.episode = episodeAPI.getId();
        this.episodeName = episodeAPI.getName();
    }

    public long getEpisode() {
        return episode;
    }

    public void setEpisode(long episode) {
        this.episode = episode;
    }

    public String getEpisodeName() {
        return episodeName;
    }

    public void setEpisodeName(String episodeName) {
        this.episodeName = episodeName;
    }

    public Set<CharacterModel> getCharacters() {
        return characters;
    }

    public void setCharacters(Set<CharacterModel> characters) {
        this.characters = characters;
    }

}
