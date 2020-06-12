package com.larissaheloisa.apib2w.dto;

import java.io.Serializable;

public class PlanetDTOPost implements Serializable{

	private static final long serialVersionUID = 1L;

	private String name;
	private String climate;
	private String terrain;
	
	public PlanetDTOPost() {
		
	}

	public PlanetDTOPost(String name, String climate, String terrain) {
		super();
		this.name = name;
		this.climate = climate;
		this.terrain = terrain;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClimate() {
		return climate;
	}

	public void setClimate(String climate) {
		this.climate = climate;
	}

	public String getTerrain() {
		return terrain;
	}

	public void setTerrain(String terrain) {
		this.terrain = terrain;
	}
}
