package br.com.celeritech.desafio.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.ManyToOne;

import br.com.celeritech.desafio.models.Location;
import br.com.celeritech.desafio.models.Personagem;

public class PersonagemDto {

	private Long id;
	private String name;
	private String status;
	private String species;
	private String gender;
	private LocalDateTime created;
	private String origin; // OBJECT
	private String location;

	public PersonagemDto(Personagem character) {
		this.id = character.getId();
		this.name = character.getName();
		this.status = character.getStatus();
		this.species = character.getSpecies();
		this.gender = character.getGender();
		this.created = character.getCreated();
		this.origin = character.getOrigin().getName();
		this.location = character.getLocation().getName();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	
	

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public static List<PersonagemDto> converter(List<Personagem> characters) {
		return characters.stream().map(PersonagemDto::new).collect(Collectors.toList());
	}

}
