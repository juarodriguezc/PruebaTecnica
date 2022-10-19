package com.juarodriguezc.api.services;

import com.juarodriguezc.api.requestModels.CharacterAPI;
import com.juarodriguezc.api.requestModels.EpisodeResponseAPI;
import com.juarodriguezc.api.requestModels.EpisodeAPI;

import com.juarodriguezc.api.requestModels.LocationAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

@Service
public class APIService {
    @Autowired
    private RestTemplate restClient;

    static String url = "https://rickandmortyapi.com/api/";

    public List<EpisodeAPI> getAllEpisodes() {
        EpisodeResponseAPI apiEpisodes = null;
        try {
            apiEpisodes = restClient.getForObject(url, EpisodeResponseAPI.class);
        } catch (HttpClientErrorException e) {
            return null;
        }
        return apiEpisodes.getResults();
    }

    public ResponseEntity<EpisodeAPI> getEpisodeById(long id) {
        ResponseEntity<EpisodeAPI> episode = null;
        try {
            episode = restClient.getForEntity(url + "episode/" + id, EpisodeAPI.class);
        } catch (HttpClientErrorException e) {
            return new ResponseEntity<>(e.getStatusCode());
        }
        return episode;
    }

    public List<CharacterAPI> getListCharacters(List<String> listURL) {
        List<CharacterAPI> listCharacter = new ArrayList<>();
        CharacterAPI character;
        for (String cURL : listURL) {
            try {
                character = restClient.getForObject(cURL, CharacterAPI.class);
            } catch (HttpClientErrorException e) {
                return null;
            }
            listCharacter.add(character);
        }
        return listCharacter;
    }

    public Hashtable<CharacterAPI, LocationAPI> getHashLocations(List<CharacterAPI> lCharacters) {
        Hashtable<CharacterAPI, LocationAPI> hashLocations = new Hashtable<>();
        for (CharacterAPI character : lCharacters) {
            LocationAPI location = null;
            try {
                String lURL = character.getLocation().getUrl();
                if(!lURL.equals(""))
                    location = restClient.getForObject(lURL, LocationAPI.class);
            } catch (HttpClientErrorException e) {
                return null;
            }
            if(location != null){
                hashLocations.put(character, location);
            }
        }
        return hashLocations;
    }
}
