package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Clase;

@Repository
public interface ClaseRepository extends CrudRepository<Clase, Long>{
	
	List<Clase> findAll();
}
