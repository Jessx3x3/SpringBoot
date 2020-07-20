package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.License;
import com.example.demo.models.Person;
import com.example.demo.services.PersonService;

@RestController
public class PersonApi {
	
	@Autowired
	private  PersonService personService;
	
	@RequestMapping(value="/api/persons", method=RequestMethod.GET)
	public List<Person> index(){
		return personService.allPersons();
	}
	
	@RequestMapping(value="/api/person", method=RequestMethod.GET)
	public Person getPerson(@RequestParam(value="id_person") Long id_person){
		return personService.getById(id_person);
	}
	
	@RequestMapping(value="/api/persons", method=RequestMethod.POST)
	public Person create(@RequestParam(value="firstName") String firstName, @RequestParam(value="lastName") String lastName) {
		Person person = new Person(firstName, lastName);
		
		return personService.createPerson(person);
	}
	

}
