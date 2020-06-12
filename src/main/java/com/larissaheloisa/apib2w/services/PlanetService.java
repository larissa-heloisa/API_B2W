package com.larissaheloisa.apib2w.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.larissaheloisa.apib2w.domain.Planet;
import com.larissaheloisa.apib2w.dto.PlanetDTO;
import com.larissaheloisa.apib2w.dto.PlanetDTOPost;
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
	
	public Planet insert(Planet obj) {
		return repository.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public Planet fromDTO(PlanetDTO objDto) {
		return new Planet(objDto.getId(), objDto.getName(), objDto.getClimate(), objDto.getTerrain(), objDto.getAppearence());
	}
	
	public Planet fromDTOPost(PlanetDTOPost objDtoPost) {
		return new Planet(objDtoPost.getName(), objDtoPost.getClimate(), objDtoPost.getTerrain());
	}
	
	public Planet findByName(String name) {
		return repository.findByName(name);
	}
	

	
}
