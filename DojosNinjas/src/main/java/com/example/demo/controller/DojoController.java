package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.models.Dojo;
import com.example.demo.service.DojoService;

@Controller
public class DojoController {

	private final DojoService dojoService;
	
	public DojoController(DojoService dojoService) {
		this.dojoService = dojoService; 
	}
	
	@RequestMapping(value="/dojos/new", method=RequestMethod.GET)
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "addDojo";
	}
	
	@RequestMapping(value="dojos", method=RequestMethod.POST)
	public String addNewDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "addDojo";
		}else {
			dojoService.addDojo(dojo);
			return "addNinja";
		}
	}
	
}
