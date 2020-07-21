package com.example.demo.controllers;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.models.Estudiante;
import com.example.demo.services.EstudianteService;


@Controller
public class EstudianteController {

	private final EstudianteService estudianteService;
	
	public EstudianteController(EstudianteService estudianteService) {
		this.estudianteService = estudianteService;
	}
	
	@RequestMapping(value="estudiantes/new", method=RequestMethod.GET)
	public String newPerson(@ModelAttribute("estudiante") Estudiante estudiante) {
		
		return "newStudent";
	}
	
	@RequestMapping(value="estudiantes", method=RequestMethod.POST)
	public String crearEstudiante(@Valid @ModelAttribute("estudiante") Estudiante estudiante, BindingResult result) {
		if(result.hasErrors()) {
			return "newStudent";
		}else {
			estudianteService.crearEstudiante(estudiante);
			return "redirect:/estudiantes/new";
		}
	}
	
}
