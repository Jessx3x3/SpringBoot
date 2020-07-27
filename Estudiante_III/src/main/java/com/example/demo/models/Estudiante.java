package com.example.demo.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="estudiantes")
public class Estudiante {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private Integer age;
	
	@OneToOne(mappedBy="estudiante", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Contacto contacto;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dormitorio_id")
	private Dormitorio dormitorio;
	
	@ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(
	        name = "estudiantes_clases", 
	        joinColumns = @JoinColumn(name = "estudiante_id"), 
	        inverseJoinColumns = @JoinColumn(name = "clase_id")
	    )
	private List<Clase> clases;
	
	public Estudiante() {}

	public Estudiante(String firstName, String lastName, Integer age, Dormitorio dormitorio) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.dormitorio = dormitorio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Dormitorio getDormitorio() {
		return dormitorio;
	}

	public void setDormitorio(Dormitorio dormitorio) {
		this.dormitorio = dormitorio;
	}

	public Contacto getContacto() {
		return contacto;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}

	public List<Clase> getClases() {
		return clases;
	}

	public void setClases(List<Clase> clases) {
		this.clases = clases;
	}
	
	
	
	
}
