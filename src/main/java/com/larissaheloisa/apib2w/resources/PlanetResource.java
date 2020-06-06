package com.larissaheloisa.apib2w.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.larissaheloisa.apib2w.domain.Planet;
import com.larissaheloisa.apib2w.services.PlanetService;

@RestController
@RequestMapping(value="/planets")
public class PlanetResource {
	
	@Autowired
	private PlanetService service;
	
	@GetMapping
	public ResponseEntity<List<Planet>> findAll(){
		List<Planet> list = service.findAll();
		return ResponseEntity.ok().body(list);
	
		
	}

}
