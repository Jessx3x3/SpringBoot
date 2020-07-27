package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Dormitorio;
import com.example.demo.models.Estudiante;
import com.example.demo.repository.DormitorioRepository;

@Service
public class DormitorioService {
	
	@Autowired
	private DormitorioRepository dormitorioRepository;
	
	public Dormitorio addDormitorio(Dormitorio dormitorio) {
		return dormitorioRepository.save(dormitorio);
	}
	
	public List<Dormitorio> getDormitorio(){
		return dormitorioRepository.findAll();
	}
	
	public Dormitorio crearDormitorio(String name) {
		Dormitorio dormitorio = new Dormitorio(name);
		
		return dormitorioRepository.save(dormitorio);
	}
	
	public Dormitorio getById(Long id){
		Optional<Dormitorio> optionalDormitorio = this.dormitorioRepository.findById(id);
		if (optionalDormitorio.isPresent()) {
			return optionalDormitorio.get();
		}else{
		return null;
		}
	}
}
