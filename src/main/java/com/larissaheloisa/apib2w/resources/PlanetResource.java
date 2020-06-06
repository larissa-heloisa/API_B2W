package com.larissaheloisa.apib2w.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.larissaheloisa.apib2w.domain.Planet;
import com.larissaheloisa.apib2w.dto.PlanetDTO;
import com.larissaheloisa.apib2w.services.PlanetService;

@RestController
@RequestMapping(value="/planets")
public class PlanetResource {
	
	@Autowired
	private PlanetService service;
	
	@GetMapping
	public ResponseEntity<List<PlanetDTO>> findAll(){
		List<Planet> list = service.findAll();
		List<PlanetDTO> listDto = list.stream().map(x -> new PlanetDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	
		
	}

}
