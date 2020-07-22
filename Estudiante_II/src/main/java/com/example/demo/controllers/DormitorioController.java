package com.example.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Dormitorio;
import com.example.demo.services.DormitorioService;
import com.example.demo.services.EstudianteService;

@Controller
public class DormitorioController {
	
	@Autowired
	private final DormitorioService dormitorioService;
	@Autowired
	private EstudianteService estudianteService;
	
	public DormitorioController(DormitorioService dormitorioService) {
		this.dormitorioService = dormitorioService;
	}
	
	@RequestMapping(value="dorms/create")
	public String crearDormitorio(@RequestParam(value="name") String name) {
		
		Dormitorio newDormitorio = new Dormitorio(name);
		
		dormitorioService.addDormitorio(newDormitorio);

		return "redirect:/student/dormitorio/{id}";
		
		//dorms/create?name=Manza
	}
	
}
