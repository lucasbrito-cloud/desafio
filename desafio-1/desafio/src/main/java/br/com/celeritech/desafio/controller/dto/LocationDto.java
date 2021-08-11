package br.com.celeritech.desafio.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.celeritech.desafio.models.Location;
import br.com.celeritech.desafio.models.Personagem;

public class LocationDto {

	private Long id;
	private String name;
	private String dimension;
	private String residents;
	private LocalDateTime created = LocalDateTime.now();
	
	public LocationDto(Location location) {
		this.id = location.getId();
		this.name = location.getName();
		this.dimension = location.getDimension();
		this.residents = location.getResidents().toString();
		this.created = location.getCreated();
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
	public LocalDateTime getCreated() {
		return created;
	}
	public void setCreated(LocalDateTime created) {
		this.created = created;
	}
	
	public static List<LocationDto> converter(List<Location> location) {
		return location.stream().map(LocationDto::new).collect(Collectors.toList());
	}
	
}
