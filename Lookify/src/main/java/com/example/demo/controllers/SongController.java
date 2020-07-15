package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Song;
import com.example.demo.services.SongService;

@Controller
public class SongController {

	private final SongService songService;
	
	public SongController(SongService songService) {
		this.songService = songService;
	}
	
	@RequestMapping("")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/songs/new")
	public String newSong(@ModelAttribute("song") Song song) {
		return "addSong";
	}
	
	@RequestMapping(value="/songs", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("song") Song song, BindingResult result) {
        if (result.hasErrors()) {
            return "addSong";
        } else {
        	songService.createSong(song);
            return "redirect:/songs";
        }
    }
	
	@RequestMapping("/songs")
	public String dashboard(Model model) {
		List<Song> songs = songService.allSongs();
		model.addAttribute("songs", songs);
		return "dashboard";
	}

    @RequestMapping("/songs/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
    	
        model.addAttribute("song", songService.findSong(id));
    	
    	return "show";
    }
    
    @RequestMapping(value="/songs/{id}/delete", method=RequestMethod.POST)
    public String destroy(@PathVariable("id") Long id, @RequestParam(value="aux") String aux) {
    	if(aux.equals("delete")) {
    	  songService.deleteSong(id);
    		 return "redirect:/songs";
    	}
    	return "redirect:/songs";
    	
    }
    
    @GetMapping("/search/topten")
    public String getOrder(Model model){
    	
    	List<Song> songs = songService.findAllOrderBy();
    	model.addAttribute("songs", songs);
    	return "topTen";
    }
    
    @GetMapping("/search")
    public String getTitle(Model model, @RequestParam(value="searchArtist") String searchArtist){
    	
    	model.addAttribute("searchArtist", searchArtist);
		model.addAttribute("songs", songService.getSongsByArtist(searchArtist));
    	
    	
    	return "artist";
    }
    
    @RequestMapping("search/songs/{id}")
    public String showA(@PathVariable("id") Long id, Model model) {
    	
        model.addAttribute("song", songService.findSong(id));
    	
    	return "show";
    }
}
