package com.example.demo.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@RequestMapping(value = "/contacts/create")
	public String testComplexObject (@RequestParam(value="student") Long student ,@RequestParam(value="address") String address, @RequestParam(value="city") String city, @RequestParam(value="state") String state){
	   
		Estudiante estudiante = estudianteService.getById(student);
		
		Contacto contacto = new Contacto(address, city, state, estudiante);
		
		contactoService.addContacto(contacto);
		
		return "redirect:/contacts/dashboard";
		
		///contacts/create?student=10&address=1234%20Some%20Street&city=Los%20Angeles&state=CA
	}
	
	@RequestMapping(value="contacts/dashboard", method=RequestMethod.GET)
	public String showValue(Model model) {
		List<Contacto> contactos = contactoService.getContacto();
		
		model.addAttribute("contactos", contactos);
		
		return "dashboardContacto";
	}

}
