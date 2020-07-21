package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Dojo;
import com.example.demo.models.Ninja;
import com.example.demo.repository.NinjaRepository;

@Service
public class NinjaService {

	private final NinjaRepository ninjaRepository;
	
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	
	public Ninja addNinja(Ninja ninja) {
		return ninjaRepository.save(ninja);
	}
	
	public List<Ninja> allNinjas(){
		return ninjaRepository.findAll();
	}
	
	public Ninja getById(Long id){
		Optional<Ninja> optionalNinja = this.ninjaRepository.findById(id);
		if (optionalNinja.isPresent()) {
			return optionalNinja.get();
		}else{
		return null;
		}
	}
	
	public void deleteNinja(Long id) {
		ninjaRepository.deleteById(id);
    }
	
	public Ninja crearNinja(Dojo dojo, String firstName, String lastName, Integer age) {
		
		Ninja newNinja = new Ninja(dojo, firstName, lastName, age);
		
		return ninjaRepository.save(newNinja);
	}
}
