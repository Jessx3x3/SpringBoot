package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.example.demo.models.Lenguaje;
import com.example.demo.repositories.LenguajeRepository;


@Service
public class LenguajeService {

	//Agregando el book al repositorio como una dependencia
    private final LenguajeRepository lenguajeRepository;
    
    public LenguajeService(LenguajeRepository lenguajeRepository) {
        this.lenguajeRepository = lenguajeRepository;
    }
    //Devolviendo todos los libros.
    public List<Lenguaje> allLenguaje() {
        return lenguajeRepository.findAll();
    }
    //Creando un libro.
    public Lenguaje createLenguaje(Lenguaje b) {
        return lenguajeRepository.save(b);
    }
    //Obteniendo la información de un libro
    public Lenguaje findLenguaje(Long id) {
        Optional<Lenguaje> optionalLenguaje = lenguajeRepository.findById(id);
        if(optionalLenguaje.isPresent()) {
            return optionalLenguaje.get();
        } else {
            return null;
        }
    }
    
    public Lenguaje updateLenguaje(long id, String name, String creator, double version) {
    	
    	if(lenguajeRepository.findById(id).isPresent()) {
    		Lenguaje lenguaje = lenguajeRepository.findById(id).get();
    		
    		lenguaje.setName(name);
    		lenguaje.setCreator(creator);
    		lenguaje.setVersion(version);

    		return lenguajeRepository.save(lenguaje);

    	}
    
    	return null;
    }
    
    public void deleteLenguaje(Long id) {
    
    	lenguajeRepository.deleteById(id);
    }

   
}
