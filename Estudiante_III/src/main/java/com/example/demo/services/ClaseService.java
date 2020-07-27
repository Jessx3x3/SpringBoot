package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Clase;
import com.example.demo.models.Estudiante;
import com.example.demo.repository.ClaseRepository;

@Service
public class ClaseService {
	
	private final ClaseRepository claseRepository;
	
	public ClaseService(ClaseRepository claseRepository) {
		this.claseRepository = claseRepository;
	}
	
	public Clase addClase(Clase clase) {
		return claseRepository.save(clase);
	}
	
	public List<Clase> getClase(){
		return claseRepository.findAll();
	}
	
	public Clase createClase(String name) {
		Clase clase = new Clase(name);
		return claseRepository.save(clase);
	}
	
	public Clase getById(Long id){
		Optional<Clase> optionalClase = this.claseRepository.findById(id);
		if (optionalClase.isPresent()) {
			return optionalClase.get();
		}else{
		return null;
		}
	}
}
