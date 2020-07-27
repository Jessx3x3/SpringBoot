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
import com.example.demo.services.DormitorioService;
import com.example.demo.services.EstudianteService;

@Controller
public class DormitorioController {
	
	@Autowired
	private final DormitorioService dormitorioService;
	@Autowired
	private EstudianteService estudianteService;
	private Dormitorio dormitorio;
	
	public DormitorioController(DormitorioService dormitorioService) {
		this.dormitorioService = dormitorioService;
	}
	
	@RequestMapping(value="dorms/create")
	public String crearDormitorio(@RequestParam(value="name") String name, Model model) {
		
		Dormitorio newDormitorio = new Dormitorio(name);
		
		dormitorioService.addDormitorio(newDormitorio);
		
		List<Estudiante> est = estudianteService.getEstudiantes();
		
		model.addAttribute("newDormitorio", dormitorioService.getById(newDormitorio.getId()));
		model.addAttribute("est", est);

		return "dashboardDormitorio";
		
		//http://localhost:8080/dorms/create?name=Manza
	}

	@RequestMapping("dashboardDomitoriosRegistros")
	public String verDomitorios() {
		
		return null;
	}
	
	
	
	/*
	@RequestMapping(value="student/dormitorio", method=RequestMethod.GET)
	public String showDeptos(@PathVariable("id") Long id, Model model) {
		
		List<Estudiante> estudiantes = estudianteService.getEstudiantes();
		model.addAttribute("estudiantes", estudiantes);
		
		model.addAttribute("dormitorio", dormitorioService.getById(id));

		return "dashboardDormitorio";
	}
	 */
	
}
