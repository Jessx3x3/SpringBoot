package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Dojo;
import com.example.demo.repository.DojoRepository;

@Service
public class DojoService {

	private final DojoRepository dojoRepository;
	
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	
	public Dojo addDojo(Dojo dojo) {
		return dojoRepository.save(dojo);
	}
	
	public List<Dojo> allDojos(){
		return dojoRepository.findAll();
	}
	
	public void deleteDojo(Long id) {
		dojoRepository.deleteById(id);
    }
	
	public Dojo getById(Long id){
		Optional<Dojo> optionalDojo = this.dojoRepository.findById(id);
		if (optionalDojo.isPresent()) {
			return optionalDojo.get();
		}else{
		return null;
		}
	}
	
	
}
