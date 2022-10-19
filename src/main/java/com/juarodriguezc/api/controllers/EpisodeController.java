package com.juarodriguezc.api.controllers;

import com.juarodriguezc.api.models.CharacterModel;
import com.juarodriguezc.api.models.EpisodeModel;
import com.juarodriguezc.api.requestModels.CharacterAPI;
import com.juarodriguezc.api.requestModels.EpisodeAPI;
import com.juarodriguezc.api.requestModels.LocationAPI;
import com.juarodriguezc.api.services.APIService;
import com.juarodriguezc.api.services.CharacterService;
import com.juarodriguezc.api.services.EpisodeService;
import com.juarodriguezc.api.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/episode")
public class EpisodeController {
    @Autowired
    EpisodeService episodeService;

    @Autowired
    LocationService locationService;

    @Autowired
    CharacterService characterService;

    @Autowired
    APIService apiService;

    @GetMapping
    public List<EpisodeModel> getAllEpisodes() {
        return episodeService.getAllEpisodes();
    }

    @DeleteMapping
    public ArrayList<EpisodeModel> deleteAllEpisodes(){
        episodeService.deleteAllEpisodes();
        ArrayList<EpisodeModel> episodeModels = episodeService.getAllEpisodes();
        return episodeModels;
    }


    @GetMapping(path = "/{id}")
    public ResponseEntity getEpisodeById(@PathVariable("id") Long id) {
        //Call the external api
        ResponseEntity<EpisodeAPI> episodeAPI = apiService.getEpisodeById(id);
        //Check if episode not exists
        if (episodeAPI.getStatusCode() != HttpStatus.OK) {
            return episodeAPI;
        }
        EpisodeModel episodeModel = new EpisodeModel(episodeAPI.getBody());
        //Insert the episode into the database
        try {
            episodeModel = episodeService.insertEpisode(episodeModel);
        } catch (Exception e) {
        }
        //Get the characters
        List<CharacterAPI> lCharacters = apiService.getListCharacters(episodeAPI.getBody().getCharacters());

        //For each character get the location
        Hashtable<CharacterAPI, LocationAPI> hLocations = apiService.getHashLocations(lCharacters);

        //Insert the locations into the database
        locationService.insertLocations(hLocations);

        //Insert the character and join the location
        List<CharacterModel> lCharacterModel = characterService.insertCharacterLocation(hLocations);

        //Join the characters and the episode
        episodeModel = episodeService.joinEpisodeCharacters(episodeModel, lCharacterModel);

        return ResponseEntity.ok(episodeModel);
    }



}
