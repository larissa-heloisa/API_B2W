package com.larissaheloisa.apib2w.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.larissaheloisa.apib2w.domain.Planet;

@Repository
public interface PlanetRepository extends MongoRepository<Planet, String> {

}
