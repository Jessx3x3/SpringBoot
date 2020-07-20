package com.example.demo.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.License;
import com.example.demo.models.Person;
import com.example.demo.repositories.PersonRepository;
import com.example.demo.services.LicenseService;
import com.example.demo.services.PersonService;

@RestController
public class LicenseApi {

	@Autowired
	private LicenseService licenseService;
	@Autowired
	private PersonRepository personRepository;
	
	@RequestMapping(value="api/licenses", method=RequestMethod.GET)
	public List<License> index(){
		return licenseService.allLicenses();
	}
	
	@RequestMapping(value="/api/licenses", method=RequestMethod.POST)
	public License create(@RequestParam(value="expirationDate") String expirationDate, @RequestParam(value="state") String state, @RequestParam(value="person_ID") Long person_ID) {
		Optional<Person> optionalPerson = personRepository.findById(person_ID);
		if (optionalPerson.isPresent()) {
			Person persona = optionalPerson.get();

			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date();;
			try {
				date = formatter.parse(expirationDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			License license = new License(date, state, persona);
			return licenseService.createLicense(license);
			
		}else {
			return null;
		}
		
		
		
	}

}
