package br.com.celeritech.desafio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.celeritech.desafio.models.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {

	Location findByName(String name);

//	List<Location> findByNome(String name);
}
