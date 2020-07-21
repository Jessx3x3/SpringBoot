package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Dojo;

@Repository
public interface DojoRepository extends CrudRepository<Dojo, Long>{

	List<Dojo> findAll();
	
}
