package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Dormitorio;

@Repository
public interface DormitorioRepository extends CrudRepository<Dormitorio, Long>{
	
	List<Dormitorio> findAll();

}
