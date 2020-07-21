package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.models.Dojo;
import com.example.demo.models.Ninja;
import com.example.demo.service.DojoService;
import com.example.demo.service.NinjaService;

@Controller
public class NinjaController {
	
	private final NinjaService ninjaService;
	@Autowired
	private DojoService dojoService;
	
	public NinjaController(NinjaService ninjaService) {
		this.ninjaService = ninjaService;
	}
	
	@RequestMapping(value="/ninjas/new", method=RequestMethod.GET)
	public String newDojo(Model model) {
		
		List<Ninja> ninjas = ninjaService.allNinjas();
		
		model.addAttribute("ninjas", ninjas);
		
		return "addNinja";
	}

	@RequestMapping(value="ninjas", method=RequestMethod.POST)
	public String createNinja(@Valid @ModelAttribute("dojo") Long dojo, @ModelAttribute("firstName") String firstName, @ModelAttribute("lastName") String lastName, @ModelAttribute("age") Integer age, BindingResult result, Model model) {
		
		if(result.hasErrors()){
			return "addNinja";
		}else {
			
			Dojo newDojo = dojoService.getById(dojo);
			
			Ninja ninjas = ninjaService.crearNinja(newDojo, firstName, lastName, age);
			
			newDojo.getNinjas().add(ninjas);
			
			model.addAttribute("ninjas", ninjas);
			return "redirect:/ninjas/index";
		}
	
	}
	
	@RequestMapping(value="ninjas/index", method=RequestMethod.GET)
	public String index(Model model) {
		
		List<Ninja> ninjas = ninjaService.allNinjas();
		
		model.addAttribute("ninjas", ninjas);
		
		return "members";
	}
	

}
