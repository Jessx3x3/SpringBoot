package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Estudiante;
import com.example.demo.repository.EstudianteRepository;

@Service
public class EstudianteService {
	
	private final EstudianteRepository estudianteRepository;
	
	public EstudianteService(EstudianteRepository estudianteRespository) {
		this.estudianteRepository = estudianteRespository;
	}
	
	public Estudiante crearEstudiante(Estudiante estudiante) {
		return estudianteRepository.save(estudiante);
	}
	
	public List<Estudiante> getEstudiantes(){
		return estudianteRepository.findAll();
	}
	
	public Estudiante getById(Long id){
		Optional<Estudiante> optionalEstudiante = this.estudianteRepository.findById(id);
		if (optionalEstudiante.isPresent()) {
			return optionalEstudiante.get();
		}else{
		return null;
		}
	}
}
