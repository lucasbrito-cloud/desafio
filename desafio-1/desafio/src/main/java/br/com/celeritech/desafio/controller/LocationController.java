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

import br.com.celeritech.desafio.controller.dto.LocationDto;
import br.com.celeritech.desafio.controller.dto.PersonagemDto;
import br.com.celeritech.desafio.controller.form.AtualizacaoLocationForm;
import br.com.celeritech.desafio.controller.form.AtualizacaoPersonagemForm;
import br.com.celeritech.desafio.controller.form.LocationForm;
import br.com.celeritech.desafio.controller.form.PersonagemForm;
import br.com.celeritech.desafio.models.Location;
import br.com.celeritech.desafio.models.Personagem;
import br.com.celeritech.desafio.repository.CharacterRepository;
import br.com.celeritech.desafio.repository.LocationRepository;

@RestController
@RequestMapping("/locations")
public class LocationController {

	@Autowired
	private CharacterRepository characterRepository;

	@Autowired
	private LocationRepository locationRepository;

	@GetMapping
	public List<LocationDto> lista(String nameLocation) {
		if (nameLocation == null) {
			List<Location> location = locationRepository.findAll();
			return LocationDto.converter(location);
		} else {
			List<Location> location = (List<Location>) locationRepository.findByName(nameLocation);
			return LocationDto.converter(location);

		}
	}

	@PostMapping
	@Transactional
	public ResponseEntity<LocationDto> cadastrar(@RequestBody LocationForm form, UriComponentsBuilder uriBuilder) {
		Location location = form.converter(characterRepository);
		locationRepository.save(location);

		URI uri = uriBuilder.path("/locations/{id}").buildAndExpand(location.getId()).toUri();
		return ResponseEntity.created(uri).body(new LocationDto(location));
	}
	
	@GetMapping("/{id}")
	public LocationDto detalhado(@PathVariable Long id) {
		Location location = locationRepository.getOne(id);
		return new LocationDto(location);
	}
	
	@PutMapping("/{id}")
	@Transactional	
	public ResponseEntity<LocationDto> atualizar(@PathVariable Long id, @RequestBody AtualizacaoLocationForm form){
		Location location = form.atualizar(id, locationRepository);
		
		return ResponseEntity.ok(new LocationDto(location));
		
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity remover(@PathVariable Long id) {
		
		locationRepository.deleteById(id);
		
		return ResponseEntity.ok().build();
		
	}
}
