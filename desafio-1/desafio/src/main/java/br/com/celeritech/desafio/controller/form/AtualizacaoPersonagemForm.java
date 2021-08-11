package br.com.celeritech.desafio.controller.form;

import br.com.celeritech.desafio.models.Personagem;
import br.com.celeritech.desafio.repository.CharacterRepository;

public class AtualizacaoPersonagemForm {

	private String name;
	private String status;
	private String species;
	private String gender;

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

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Personagem atualizar(Long id, CharacterRepository characterRepository) {
		Personagem personagem = characterRepository.getById(id);

		personagem.setName(this.name);
		personagem.setStatus(this.status);
		personagem.setSpecies(this.species);
		personagem.setGender(this.gender);

		return personagem;

	}

}
