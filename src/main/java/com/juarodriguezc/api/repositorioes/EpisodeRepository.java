package com.juarodriguezc.api.repositorioes;

import com.juarodriguezc.api.models.EpisodeModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EpisodeRepository extends CrudRepository<EpisodeModel, Long> {
    Optional<EpisodeModel> findById(Long id);
}
