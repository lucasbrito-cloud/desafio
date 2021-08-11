package br.com.celeritech.desafio.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.celeritech.desafio.controller.dto.PersonagemDto;
import br.com.celeritech.desafio.controller.form.AtualizacaoPersonagemForm;
import br.com.celeritech.desafio.controller.form.PersonagemForm;
import br.com.celeritech.desafio.repository.CharacterRepository;
import br.com.celeritech.desafio.repository.LocationRepository;
import br.com.celeritech.desafio.models.Personagem;

@RestController
@RequestMapping("/characters")
public class CharacterController {

	@Autowired
	private CharacterRepository characterRepository;

	@Autowired
	private LocationRepository locationRepository;

	@GetMapping
	public List<PersonagemDto> lista(String namePersonagem) {
		if (namePersonagem == null) {
			List<Personagem> characters = characterRepository.findAll();
			return PersonagemDto.converter(characters);
		} else {
			List<Personagem> characters = characterRepository.findByName(namePersonagem);
			return PersonagemDto.converter(characters);

		}
	}

	@PostMapping
	@Transactional
	public ResponseEntity<PersonagemDto> cadastrar(@RequestBody PersonagemForm form, UriComponentsBuilder uriBuilder) {
		Personagem character = form.converter(locationRepository);
		characterRepository.save(character);

		URI uri = uriBuilder.path("/characters/{id}").buildAndExpand(character.getId()).toUri();
		return ResponseEntity.created(uri).body(new PersonagemDto(character));
	}
	
	@GetMapping("/{id}")
	public PersonagemDto detalhado(@PathVariable Long id) {
		Personagem personagem = characterRepository.getOne(id);
		return new PersonagemDto(personagem);
	}
		
	@PutMapping("/{id}")
	@Transactional	
	public ResponseEntity<PersonagemDto> atualizar(@PathVariable Long id, @RequestBody AtualizacaoPersonagemForm form){
		Personagem personagem = form.atualizar(id, characterRepository);
		
		return ResponseEntity.ok(new PersonagemDto(personagem));
		
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity remover(@PathVariable Long id) {
		
		characterRepository.deleteById(id);
		
		return ResponseEntity.ok().build();
		
	}
		
		
	}
