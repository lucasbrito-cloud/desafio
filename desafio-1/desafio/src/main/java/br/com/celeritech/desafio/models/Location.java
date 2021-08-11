package br.com.celeritech.desafio.models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String dimension;
	@OneToMany
	private List<Personagem> residents;
	private LocalDateTime created = LocalDateTime.now();

	
	public Location() {

	}

	public Location(String name, String dimension, List<Personagem> residents) {
		super();
		this.name = name;
		this.dimension = dimension;
		this.residents = residents;
		
	}
	
	
	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(created, dimension, id, name, residents);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		return Objects.equals(created, other.created) && Objects.equals(dimension, other.dimension)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(residents, other.residents);
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

	public List<Personagem> getResidents() {
		return residents;
	}

	public void setResidents(List<Personagem> residents) {
		this.residents = residents;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

}
