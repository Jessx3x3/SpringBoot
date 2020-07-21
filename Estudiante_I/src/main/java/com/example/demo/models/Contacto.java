package com.example.demo.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="contactos")
public class Contacto {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	private String address;
	
	private String city;
	
	private String state;
	
	@JoinColumn(name="estudiante_id",unique = true)
    @OneToOne(cascade=CascadeType.ALL)
	private Estudiante estudiante;

	public Contacto() {}
	
	public Contacto(String address, String city, String state, Estudiante estudiante) {
		super();
		this.id = id;
		this.address = address;
		this.city = city;
		this.state = state;
		this.estudiante = estudiante;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
	
}
