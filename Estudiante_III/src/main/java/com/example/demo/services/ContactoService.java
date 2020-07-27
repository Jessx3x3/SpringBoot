package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.Contacto;
import com.example.demo.models.Estudiante;
import com.example.demo.repository.ContactoRepository;

@Service
public class ContactoService {

	private final ContactoRepository contactoRepository;
	
	public ContactoService(ContactoRepository contactoRepository) {
		this.contactoRepository = contactoRepository;
	}
	
	public Contacto addContacto(Contacto contact) {
		return contactoRepository.save(contact);
	}
	
	public List<Contacto> getContacto(){
		return contactoRepository.findAll();
	}
	
	public Contacto crearContacto(String address, String city, String state, Estudiante estudiante) {
		
		Contacto contacto = new Contacto(address, city, state, estudiante);
		
		return contactoRepository.save(contacto);
		
	}
}
