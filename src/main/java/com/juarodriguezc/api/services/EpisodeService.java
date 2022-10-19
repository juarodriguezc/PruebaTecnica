package com.juarodriguezc.api.services;


import com.juarodriguezc.api.models.CharacterModel;
import com.juarodriguezc.api.models.EpisodeModel;
import com.juarodriguezc.api.repositorioes.CharacterRepository;
import com.juarodriguezc.api.repositorioes.EpisodeRepository;
import com.juarodriguezc.api.requestModels.CharacterAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EpisodeService {
    @Autowired
    EpisodeRepository episodeRepository;

    @Autowired
    CharacterRepository characterRepository;

    public ArrayList<EpisodeModel> getAllEpisodes() {
        return (ArrayList<EpisodeModel>) episodeRepository.findAll();
    }

    public Optional<EpisodeModel> getEpisodeById(Long id) {
        return episodeRepository.findById(id);
    }

    public EpisodeModel insertEpisode(EpisodeModel episodeModel) {
        return episodeRepository.save(episodeModel);
    }

    public EpisodeModel joinEpisodeCharacters(EpisodeModel episodeModel, List<CharacterModel> lCharacters){
        Set<CharacterModel> setCharacters = episodeModel.getCharacters();
        for(CharacterModel characterModel : lCharacters){
            setCharacters.add(characterModel);
        }
        //Add to the database
        episodeModel.setCharacters(setCharacters);
        episodeRepository.save(episodeModel);
        return episodeModel;
    }
}
