package com.juarodriguezc.api.repositorioes;

import com.juarodriguezc.api.models.LocationModel;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<LocationModel, Long> {

}
