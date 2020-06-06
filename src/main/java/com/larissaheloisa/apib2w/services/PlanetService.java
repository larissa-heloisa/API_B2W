package com.larissaheloisa.apib2w.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.larissaheloisa.apib2w.domain.Planet;
import com.larissaheloisa.apib2w.repository.PlanetRepository;

@Service
public class PlanetService {
	
	@Autowired
	private PlanetRepository repository;

	public List<Planet> findAll(){
		return repository.findAll();
	}
}
