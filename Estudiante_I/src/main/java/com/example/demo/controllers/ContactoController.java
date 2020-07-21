package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.models.Contacto;
import com.example.demo.models.Estudiante;
import com.example.demo.services.ContactoService;
import com.example.demo.services.EstudianteService;

@Controller
public class ContactoController {
	
	private final ContactoService contactoService;
	@Autowired
	private EstudianteService estudianteService;
	
	public ContactoController(ContactoService contactoService) {
		this.contactoService = contactoService;
	}
	
	@RequestMapping(value="contactos/new", method=RequestMethod.GET)
	public String newContact(Model model) {
		
		List<Contacto> contactos = contactoService.getContacto();
		
		model.addAttribute("contactos",contactos);

		
		return "addContact";
	}

	@RequestMapping(value="contactos", method=RequestMethod.POST)
	public String addContact(@Valid @ModelAttribute("address") String address, @ModelAttribute("city") String city, @ModelAttribute("state") String state, @ModelAttribute("estudiante") Long estudiante,  BindingResult result ,Model model) {
		
		if(result.hasErrors()) {
		return "addContact";
		}else {
			Estudiante estudiantes = estudianteService.getById(estudiante);
			
			Contacto contactos = contactoService.crearContacto(address, city, state, estudiantes);
			
			model.addAttribute("contactos", contactos);
			
			return "redirect:/contactos/estudiante";
		}
	}
	
	@RequestMapping(value="contactos/estudiante", method=RequestMethod.GET)
	public String index(Model model) {
		
		List<Contacto> contactos = contactoService.getContacto();
		
		model.addAttribute("contactos", contactos);
		
		return "show";
	}
}
