package com.juarodriguezc.api.services;

import com.juarodriguezc.api.models.CharacterModel;
import com.juarodriguezc.api.models.LocationModel;
import com.juarodriguezc.api.repositorioes.CharacterRepository;
import com.juarodriguezc.api.repositorioes.LocationRepository;
import com.juarodriguezc.api.requestModels.CharacterAPI;
import com.juarodriguezc.api.requestModels.LocationAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.*;

@Service
public class CharacterService {

    @Autowired
    CharacterRepository characterRepository;
    @Autowired
    LocationRepository locationRepository;

    public List<CharacterModel> insertCharacterLocation(Hashtable<CharacterAPI, LocationAPI> hLocation) {
        List<CharacterModel> lCharacter = new ArrayList<>();
        Enumeration<CharacterAPI> iter = hLocation.keys();
        while (iter.hasMoreElements()) {
            CharacterAPI character = iter.nextElement();
            CharacterModel characterModel;
            try {
                //Check if the character already exists
                Optional<CharacterModel> optCharacter = characterRepository.findById(character.getId());
                if (optCharacter.isPresent()) {
                    characterModel = optCharacter.get();

                } else {
                    //Add the character
                    characterModel = characterRepository.save(new CharacterModel(character));
                }
            } catch (HttpClientErrorException e) {
                return null;
            }
            //Add the location to the character
            try{
                LocationModel locationModel = locationRepository.findById(hLocation.get(character).getId()).get();
                //Add the location to the LocationModel
                Set<CharacterModel> lChars = locationModel.getCharacters();
                lChars.add(characterModel);
                locationModel.setCharacters(lChars);
                //Add the location to the Character
                characterModel.setLocation(locationModel);
                locationRepository.save(locationModel);
                characterRepository.save(characterModel);
                lCharacter.add(characterModel);
            }
            catch (HttpClientErrorException e) {
                return null;
            }
        }
        return lCharacter;
    }
}
