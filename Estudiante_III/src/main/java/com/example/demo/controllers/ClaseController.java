package com.example.demo.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Clase;
import com.example.demo.models.Estudiante;
import com.example.demo.services.ClaseService;
import com.example.demo.services.EstudianteService;

@Controller
public class ClaseController {

	private ClaseService claseService;
	private final EstudianteService estudianteService;
	
	public ClaseController(ClaseService claseService, EstudianteService estudianteService) {
		this.claseService = claseService;
		this.estudianteService = estudianteService;
	}
	
	@RequestMapping(value="/classes/create")
	public String crearClase(@RequestParam(value="name") String name, Model model, Clase clase) {
		
		Clase newClase = new Clase(name);
		
		List<Clase> clases = claseService.getClase();
		
		List<Estudiante> estudiante = estudianteService.getEstudiantes();
		
		claseService.addClase(newClase);
		
		model.addAttribute("clases", clases);
		model.addAttribute("clase", clase);
		model.addAttribute("estudiante", estudiante);
		///classes/create?name=Java
		
		return "class";
	}
	
	@RequestMapping(value="classes/{id}", method=RequestMethod.GET)
	public String getClass(@PathVariable("id") Long id, Model model) {
		model.addAttribute("class", claseService.getById(id));
		
		return "class";
	}
	
	@RequestMapping(value="classes/student", method=RequestMethod.GET)
	public String showClases(@PathVariable("id") Long id, Model model) {
		
		model.addAttribute("estudiantes", estudianteService.getById(id));
		
		List<Clase> clases = claseService.getClase();
		model.addAttribute("clases", clases);
		
		return "class";
	}
}
