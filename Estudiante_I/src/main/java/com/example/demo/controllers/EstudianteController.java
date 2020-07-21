package com.example.demo.controllers;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Estudiante;
import com.example.demo.repository.EstudianteRepository;
import com.example.demo.services.EstudianteService;


@Controller
public class EstudianteController {

	private final EstudianteService estudianteService;
	private EstudianteRepository estudianteRepository;
	
	public EstudianteController(EstudianteService estudianteService) {
		this.estudianteService = estudianteService;
	}
	
	@RequestMapping(value = "/students/create")
	public String testComplexObject (@RequestParam(value="firstName") String firstName, @RequestParam(value="lastName") String lastName, @RequestParam(value="age") Integer age){
	   
		Estudiante estudiante = new Estudiante(firstName, lastName, age);
		
		estudianteService.crearEstudiante(estudiante);
		
		return "redirect:/students/dashboard";
		
		//http://localhost:8080/students/create?firstName=John&lastName=Doe&age=35
	}
	
	@RequestMapping(value="students/dashboard", method=RequestMethod.GET)
	public String showValue(Model model) {
		List<Estudiante> estudiantes = estudianteService.getEstudiantes();
		
		model.addAttribute("estudiantes", estudiantes);
		
		return "dashboard";
	}
}
