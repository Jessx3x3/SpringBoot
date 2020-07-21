package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Contacto;

@Repository
public interface ContactoRepository extends CrudRepository<Contacto, Long>{
	
	List<Contacto> findAll();

}
