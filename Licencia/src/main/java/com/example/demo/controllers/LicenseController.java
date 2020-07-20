package com.example.demo.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Binding;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.License;
import com.example.demo.models.Person;
import com.example.demo.services.LicenseService;
import com.example.demo.services.PersonService;

@Controller
public class LicenseController {

	private final LicenseService licenseService;
	private  PersonService personService;
	
	public LicenseController(LicenseService licenseService) {
		this.licenseService = licenseService;
	}
	
	@RequestMapping(value="/licenses/new", method=RequestMethod.GET)
	public String newLicense(@ModelAttribute("license") License license, Model model) {
		
		return "newLicense";
	}
	
	@RequestMapping(value="licenses", method=RequestMethod.POST)
	public String createLicense(@Valid @ModelAttribute("license") License license, @ModelAttribute("expirationDate") Date expirationDate, @ModelAttribute("state") String state, @ModelAttribute("person") long person, BindingResult result, Model model) {

		if(result.hasErrors()) {
			return "newLicense";
		}else {
			Person persona = personService.getById(person);
			
			model.addAttribute("persona", persona);
			
			licenseService.crearLicencia(/*license.getNumber(),*/ expirationDate, state, persona);
			return "redirect:/persons/license";
		}
	}
	
	@RequestMapping("/persons/license")
	public String index(Model model) {
		List<License> licenses = licenseService.allLicenses();
		model.addAttribute("licenses", licenses);
		
		return "show";
	}
	
}
