package com.example.demo.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="dormitorios")
public class Dormitorio {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	String name;
	
	@OneToMany(mappedBy="dormitorio", fetch = FetchType.LAZY)
    private List<Estudiante> estudiante;
	
	public Dormitorio() {}
	
	public Dormitorio(String name) {
		this.id = id;
		this.name = name;
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

	public List<Estudiante> getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(List<Estudiante> estudiante) {
		this.estudiante = estudiante;
	}
	
	
}
