package br.com.celeritech.desafio.controller.form;

import java.util.List;

import br.com.celeritech.desafio.models.Location;
import br.com.celeritech.desafio.models.Personagem;
import br.com.celeritech.desafio.repository.CharacterRepository;
import br.com.celeritech.desafio.repository.LocationRepository;

public class LocationForm {
	
	private Long id;
	private String name;
	private String dimension;
	private String residents;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDimension() {
		return dimension;
	}
	public void setDimension(String dimension) {
		this.dimension = dimension;
	}
	public String getResidents() {
		return residents;
	}
	public void setResidents(String residents) {
		this.residents = residents;
	}
	
	public Location converter(CharacterRepository characterRepository) {
		List<Personagem> personagens = characterRepository.findByName(residents);
		return new Location(name, dimension, personagens);
	}
	

}
