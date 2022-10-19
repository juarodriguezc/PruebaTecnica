package com.juarodriguezc.api.repositorioes;

import com.juarodriguezc.api.models.CharacterModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends CrudRepository<CharacterModel, Long> {

}
