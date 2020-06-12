package com.larissaheloisa.apib2w.resources;


import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.larissaheloisa.apib2w.domain.Planet;
import com.larissaheloisa.apib2w.dto.PlanetDTO;
import com.larissaheloisa.apib2w.dto.PlanetDTOPost;
import com.larissaheloisa.apib2w.services.PlanetService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/planets")
@Api(value = "API Rest Planets Star Wars")
@CrossOrigin(origins = "*")
public class PlanetResource {
	
	@Autowired
	private PlanetService service;
	
	@GetMapping
	@ApiOperation(value = "Listar Planetas")
	public ResponseEntity<List<PlanetDTO>> findAll() {
		List<Planet> list = service.findAll();
		List<PlanetDTO> listDto = list.stream().map(x -> new PlanetDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Buscar por ID")
	public ResponseEntity<PlanetDTO> findById(@PathVariable String id) {

		Planet obj = service.findById(id);
		return ResponseEntity.ok().body(new PlanetDTO(obj));
	}
	
	@GetMapping("/planet/{name}")
	@ApiOperation(value = "Buscar por Nome")
	public ResponseEntity<PlanetDTO> findByName(@PathVariable String name){
		Planet obj = service.findByName(name);
		return ResponseEntity.ok().body(new PlanetDTO(obj));	
				
	}

	@PostMapping
	@ApiOperation(value = "Adicionar um planeta")
	public ResponseEntity<Void> insert(@RequestBody PlanetDTOPost objDto) {
		Planet obj = service.fromDTOPost(objDto);
		obj.setAppearence(ConsumeAPISW.getAppearence(obj.getName()));
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Remover planeta")
	public ResponseEntity<Void> delete(@PathVariable String id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
