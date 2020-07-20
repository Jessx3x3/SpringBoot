package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Person;
import com.example.demo.repositories.PersonRepository;

@Service
public class PersonService {
	
	private final PersonRepository personRepository;
	
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	public Person createPerson(Person person) {
        return personRepository.save(person);
    }
	
	public List<Person> allPersons(){
		return personRepository.findAll();
	}
	
    public Person findPerson(Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if(optionalPerson.isPresent()) {
            return optionalPerson.get();
        } else {
            return null;
        }
    }
	
	public Person getById(Long id){
		Optional<Person> optionalPerson = this.personRepository.findById(id);
		if (optionalPerson.isPresent()) {
			return optionalPerson.get();
		}else{
		return null;
		}
	}
}
