package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.SongService;
import com.example.demo.models.Song;

@RestController
public class SongApi {

	private final SongService songService;
	
	public SongApi(SongService songservice) {
		this.songService = songservice;
	}
	
	@RequestMapping("/api/songs")
	public List<Song> index(){
		
		return songService.allSongs();
	}
	
	@RequestMapping(value="/api/songs", method=RequestMethod.POST)
	public Song create(@RequestParam(value="title") String title, @RequestParam(value="artist") String artist, @RequestParam(value="rating") int rating) {
		Song song = new Song(title, artist, rating);
		
		return songService.createSong(song);
	}
	
	@RequestMapping("/api/songs/{id}")
	public Song show(@PathVariable("id") Long id) {
		Song song = songService.findSong(id);
		
		return song;
	}
	
    @RequestMapping(value="/api/songs/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        songService.deleteSong(id);
    }
	
}