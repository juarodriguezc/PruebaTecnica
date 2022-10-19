package com.juarodriguezc.api.services;

import com.juarodriguezc.api.models.CharacterModel;
import com.juarodriguezc.api.models.EpisodeModel;
import com.juarodriguezc.api.models.LocationModel;
import com.juarodriguezc.api.repositorioes.EpisodeRepository;
import com.juarodriguezc.api.repositorioes.LocationRepository;
import com.juarodriguezc.api.requestModels.CharacterAPI;
import com.juarodriguezc.api.requestModels.LocationAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.*;

@Service
public class LocationService {
    @Autowired
    LocationRepository locationRepository;

    public Hashtable<CharacterAPI, LocationAPI> insertLocations(Hashtable<CharacterAPI, LocationAPI> hLocation) {

        Enumeration<CharacterAPI> iter = hLocation.keys();
        List<LocationModel> list = new ArrayList<>();

        while (iter.hasMoreElements()) {
            CharacterAPI characterAPI = iter.nextElement();
            try {
                //Check if the location already exists
                Optional<LocationModel> optLocation = locationRepository.findById(hLocation.get(characterAPI).getId());
                if (!optLocation.isPresent()) {
                    list.add(locationRepository.save(new LocationModel(hLocation.get(characterAPI))));
                }
            } catch (HttpClientErrorException e) {
                return null;
            }
        }
        return hLocation;
        /*
        List<LocationModel> list = new ArrayList<>();
        for (LocationAPI location : lLocation) {
            try {
                Optional<LocationModel> optLocation = locationRepository.findById(location.getId());
                if(!optLocation.isPresent()){
                    list.add(locationRepository.save(new LocationModel(location)));
                }
            } catch (HttpClientErrorException e) {
                return null;
            }
        }
         */

    }

    public Optional<LocationModel> getLocationById(long id){
        return locationRepository.findById(id);
    }

}
