package com.example.demo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.License;
import com.example.demo.models.Person;
import com.example.demo.repositories.LicenseRepository;

@Service
public class LicenseService {

	private final LicenseRepository licenseRepository;
	
	public LicenseService(LicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;
	}
	
	public License createLicense(License license) {
        return licenseRepository.save(license);
    }
	
	public List<License> allLicenses(){
		return licenseRepository.findAll();
	}

	public License crearLicencia(Date date, String state, Person person) {
		License license = new License(date, state, person);
		
		return licenseRepository.save(license);
	}
	
	public License getById(Long id){
		Optional<License> optionalLicense = this.licenseRepository.findById(id);
		if (optionalLicense.isPresent()) {
			return optionalLicense.get();
		}else{
		return null;
		}
	}
	
}
