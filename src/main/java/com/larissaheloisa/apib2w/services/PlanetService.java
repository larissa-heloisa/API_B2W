package com.larissaheloisa.apib2w.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.larissaheloisa.apib2w.domain.Planet;
import com.larissaheloisa.apib2w.repository.PlanetRepository;
import com.larissaheloisa.apib2w.services.exception.ObjectNotFoundException;

@Service
public class PlanetService {
	
	@Autowired
	private PlanetRepository repository;

	public List<Planet> findAll(){
		return repository.findAll();
	}
	
	public Planet findById(String id) {
		Optional<Planet> planet = repository.findById(id);
		if(planet.isPresent()) {
			return planet.get();
		}else {
			throw new ObjectNotFoundException("Id not found");
		}
		
	}
}
