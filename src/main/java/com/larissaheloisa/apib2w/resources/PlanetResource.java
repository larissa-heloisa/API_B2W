package com.larissaheloisa.apib2w.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.larissaheloisa.apib2w.domain.Planet;

@RestController
@RequestMapping(value="/planets")
public class PlanetResource {
	
	@GetMapping
	public ResponseEntity<List<Planet>> findAll(){
		List<Planet> list = new ArrayList<>();
		return ResponseEntity.ok().body(list);
	
		
	}

}
