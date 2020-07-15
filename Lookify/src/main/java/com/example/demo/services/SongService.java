package com.example.demo.services;

import java.util.List;

import com.example.demo.models.Song;
import com.example.demo.repositories.SongRepository;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

import java.util.Optional;

import javax.swing.SortOrder;

import org.springframework.stereotype.Service;

@Service
public class SongService {
	
	private final SongRepository songRespository;
	
	public SongService(SongRepository songRepository) {
		this.songRespository = songRepository;
	}
	
	//Obtener todas las canciones
	public List<Song> allSongs(){
		return songRespository.findAll();
	}
	
	//Crear canción
	public Song createSong(Song s) {
		return songRespository.save(s);
	}
	
	//Obtener información
	public Song findSong(Long id) {
		Optional<Song> optionalSong = songRespository.findById(id);
		
		if(optionalSong.isPresent()) {
			return optionalSong.get();
		}else {
			return null;
		}
	}

	public List<Song> findAllOrderBy() {
		
		return songRespository.findAllOrderByRatingDesc();
	}
	
	public void deleteSong(Long id) {
	    
		songRespository.deleteById(id);
    }
	
	public List<Song> getSongsByArtist(String artist){
		
		return this.songRespository.findByArtist(artist);
	}
	

}
