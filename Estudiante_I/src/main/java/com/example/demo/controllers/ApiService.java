package com.example.demo.controllers;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Contacto;
import com.example.demo.models.Estudiante;
import com.example.demo.repository.EstudianteRepository;
import com.example.demo.services.ContactoService;
import com.example.demo.services.EstudianteService;

@RestController
public class ApiService {
	
	@Autowired
	private ContactoService contactoService;
	@Autowired
	private EstudianteService estudianteService;
	@Autowired
	private EstudianteRepository estudianteRepository;
	
	@RequestMapping(value="api/contactos", method=RequestMethod.GET)
	public List<Contacto> getContactos(){
		return contactoService.getContacto();
	}
	
	@RequestMapping(value="api/estudiantes", method=RequestMethod.GET)
	public List<Estudiante> getEstudiantes(){
		return estudianteService.getEstudiantes();
	}
	
	@RequestMapping(value="api/estudiantes", method=RequestMethod.POST)
	public Estudiante newEstudiante(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("age") Integer age) {
		
		Estudiante newStudent = new Estudiante(firstName, lastName, age);
		
		return estudianteService.crearEstudiante(newStudent);
	}
	
	@RequestMapping(value="api/contactos", method=RequestMethod.POST)
	public Contacto newContacto(@RequestParam("address") String address, @RequestParam("city") String city, @RequestParam("state") String state, @RequestParam("estudiante") Long estudiante) {
	
		Optional<Estudiante> optionalStudent = estudianteRepository.findById(estudiante);
		
		if (optionalStudent.isPresent()) {
			Estudiante newEstudiante = optionalStudent.get();
			
			Contacto newContacto = new Contacto(address, city, state, newEstudiante);
			return contactoService.addContacto(newContacto);
			
		}else {
			return null;
		}	
		
	}

}
