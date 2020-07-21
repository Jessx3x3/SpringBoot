package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Estudiante;


@Repository
public interface EstudianteRepository extends CrudRepository<Estudiante, Long>{

	List<Estudiante> findAll();
}
