package com.example.demo.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="clases")
public class Clase {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "estudiantes_clases", 
        joinColumns = @JoinColumn(name = "clase_id"), 
        inverseJoinColumns = @JoinColumn(name = "estudiante_id")
    
        
    		)
    private List<Estudiante> estudiante;
    
    public Clase() {}
    
    public Clase(String name) {
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
