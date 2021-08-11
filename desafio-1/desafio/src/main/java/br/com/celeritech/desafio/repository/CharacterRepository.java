package br.com.celeritech.desafio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.celeritech.desafio.models.Location;
import br.com.celeritech.desafio.models.Personagem;

public interface CharacterRepository extends JpaRepository<Personagem, Long> {

	List<Personagem> findByName(String name);
	
//	Personagem findByName(String name);
 
}
