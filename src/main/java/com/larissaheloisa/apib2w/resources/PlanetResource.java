package com.larissaheloisa.apib2w.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<PlanetDTO> findById(@PathVariable String id){
		
		Planet obj = service.findById(id);
		return ResponseEntity.ok().body(new PlanetDTO(obj));
	}
	
	@PostMapping
	public ResponseEntity<Void>insert(@RequestBody PlanetDTO objDto){
		Planet obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
		
}
