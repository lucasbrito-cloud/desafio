package br.com.celeritech.desafio.controller.form;

import br.com.celeritech.desafio.models.Location;
import br.com.celeritech.desafio.models.Personagem;
import br.com.celeritech.desafio.repository.CharacterRepository;
import br.com.celeritech.desafio.repository.LocationRepository;

public class AtualizacaoLocationForm {

	private String name;
	private String dimension;


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

	public Location atualizar(Long id, LocationRepository locationRepository) {
		Location location = locationRepository.getById(id);

		location.setName(this.name);
		location.setDimension(this.dimension);
		
		return location;

	}

}
