package com.example.demo.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.models.Person;
import com.example.demo.services.LicenseService;
import com.example.demo.services.PersonService;

@Controller
public class PersonController {
	
	private final PersonService personService;
	LicenseService licenseService;
	
	public PersonController(PersonService personService) {
		this.personService = personService;
	}
	
	@RequestMapping("persons/new")
	public String newPerson(@ModelAttribute("person") Person person) {
		return "newPerson";
	}
	  
	@RequestMapping(value="persons", method = RequestMethod.POST)
	public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if(result.hasErrors()) {
			return "newPerson";
		}else {
			personService.createPerson(person);
			return "redirect:/index";
		}
	}
	
}
