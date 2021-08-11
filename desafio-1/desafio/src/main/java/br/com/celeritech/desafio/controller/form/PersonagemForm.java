package br.com.celeritech.desafio.controller.form;

import br.com.celeritech.desafio.models.Location;
import br.com.celeritech.desafio.models.Personagem;
import br.com.celeritech.desafio.repository.CharacterRepository;
import br.com.celeritech.desafio.repository.LocationRepository;

public class PersonagemForm {

	
	private String name;
	private String status;
	private String species;
	private String gender;
	private String nameLocation;
	private String nameOrigin;
	

	public String getNameLocation() {
		return nameLocation;
	}

	public void setLocation(String nameLocation) {
		this.nameLocation = nameLocation;
	}



	public String getNameOrigin() {
		return nameOrigin;
	}

	public void setNameOrigin(String nameOrigin) {
		this.nameOrigin = nameOrigin;
	}
	

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getName() {
		return name;
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


	public Personagem converter(LocationRepository locationRepository) {
		Location local = locationRepository.findByName(nameLocation);
		Location origin = locationRepository.findByName(nameOrigin);
		return new Personagem(name, status, species, gender, local, origin);
	}
	
	

}
