package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Dojo;
import com.example.demo.models.Ninja;
import com.example.demo.service.DojoService;
import com.example.demo.service.NinjaService;

@RestController
public class testApi {

	private final DojoService dojoService;
	private NinjaService ninjaService;
	
	public testApi(DojoService dojoService) {
		this.dojoService = dojoService;
	}
	
	@RequestMapping(value="api/dojos", method=RequestMethod.GET)
	public List<Dojo> getDojos(){
		return dojoService.allDojos();
	}
	
	@RequestMapping(value="api/ninjas", method=RequestMethod.GET)
	public List<Ninja> getNinjas(){
		return ninjaService.allNinjas();
	}
	
	@RequestMapping(value="/api/ninjas", method=RequestMethod.POST)
	public Ninja newNinja(@RequestParam("dojo") Dojo dojo, @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("age") Integer age) {
		
		Ninja ninja = new Ninja(dojo, firstName, lastName, age);
		
		return ninjaService.addNinja(ninja);
	}
	
	@RequestMapping(value="/api/dojos/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
		dojoService.deleteDojo(id);
    }
	
	@RequestMapping(value="/api/ninjas/{id}", method=RequestMethod.DELETE)
    public void destroyNinjas(@PathVariable("id") Long id) {
		ninjaService.deleteNinja(id);
    }
}
