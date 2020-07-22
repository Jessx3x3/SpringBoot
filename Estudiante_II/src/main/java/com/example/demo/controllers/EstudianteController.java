package com.example.demo.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Dormitorio;
import com.example.demo.models.Estudiante;
import com.example.demo.repository.EstudianteRepository;
import com.example.demo.services.DormitorioService;
import com.example.demo.services.EstudianteService;


@Controller
public class EstudianteController {

	private final EstudianteService estudianteService;
	@Autowired
	private EstudianteRepository estudianteRepository;
	@Autowired
	private DormitorioService dormitorioService;
	
	public EstudianteController(EstudianteService estudianteService) {
		this.estudianteService = estudianteService;
	}
	
	@RequestMapping(value = "/students/create")
	public String testComplexObject (@RequestParam(value="firstName") String firstName, @RequestParam(value="lastName") String lastName, @RequestParam(value="age") Integer age,  @RequestParam("dormitorio") Long dormitorio){
	   
		Dormitorio newDormitorio = dormitorioService.getById(dormitorio);
		
		Estudiante estudiante = new Estudiante(firstName, lastName, age, newDormitorio);
		
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
	
	@RequestMapping(value="student/dormitorio/{id}", method=RequestMethod.GET)
	public String showDeptos(@PathVariable("id") Long id, Model model) {
		
		List<Estudiante> estudiantes = estudianteService.getEstudiantes();
		model.addAttribute("estudiantes", estudiantes);
		
		model.addAttribute("dormitorio", dormitorioService.getById(id));

		return "dashboardDormitorio";
	}
}
