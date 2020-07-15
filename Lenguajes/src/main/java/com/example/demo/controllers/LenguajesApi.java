package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Lenguaje;
import com.example.demo.services.LenguajeService;


@RestController
public class LenguajesApi {
    private final LenguajeService lenguajeService;
    
    public LenguajesApi(LenguajeService lenguajeService){
        this.lenguajeService = lenguajeService;
    }
    @RequestMapping("/api/lenguajes")
    public List<Lenguaje> index() {
        return lenguajeService.allLenguaje();
    }
    
    @RequestMapping(value="/api/lenguajes", method=RequestMethod.POST)
    public Lenguaje create(@RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="version") double version) {
    	Lenguaje lenguaje = new Lenguaje(name, creator, version);
        return lenguajeService.createLenguaje(lenguaje);
    }
    
    @RequestMapping("/api/lenguajes/{id}")
    public Lenguaje show(@PathVariable("id") Long id) {
    	Lenguaje lenguaje = lenguajeService.findLenguaje(id);
        return lenguaje;
    }
    
    @RequestMapping(value="/api/lenguajes/{id}", method=RequestMethod.PUT)
    public Lenguaje update(@PathVariable("id") Long id, @RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="version") double version) {
    	Lenguaje lenguaje = lenguajeService.updateLenguaje(id, name, creator, version);
        
        return lenguaje;
    }
    
    @RequestMapping(value="/api/lenguajes/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
    	lenguajeService.deleteLenguaje(id);
    }
}