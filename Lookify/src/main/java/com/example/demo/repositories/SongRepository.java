package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Song;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

public interface SongRepository extends CrudRepository<Song,Long>{
	
	List<Song> findAll();
	
	@Query("FROM Song ORDER BY rating DESC")
	List<Song> findAllOrderByRatingDesc();
	
	List<Song> findByArtist(String artist);
	
}
