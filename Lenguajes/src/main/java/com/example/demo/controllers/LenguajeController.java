package com.example.demo.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Lenguaje;
import com.example.demo.services.LenguajeService;



@Controller
public class LenguajeController {
    private final LenguajeService lenguajeService;
    
    public LenguajeController(LenguajeService lenguajeService) {
        this.lenguajeService = lenguajeService;
    }
    @RequestMapping("/lenguajes/new")
    public String newLenguaje(@ModelAttribute("lenguaje") Lenguaje lenguaje) {
        return "index"; //new
    }
    @RequestMapping(value="/lenguajes", method=RequestMethod.POST)
    public String create(@Validated @ModelAttribute("lenguaje") Lenguaje lenguaje, BindingResult result) {
        if (result.hasErrors()) {
            return "index"; //new
        } else {
        	lenguajeService.createLenguaje(lenguaje);
            return "redirect:/lenguajes";
        }
    }
    @RequestMapping("/lenguajes")
    public String index(Model model) {
        List<Lenguaje> lenguajes = lenguajeService.allLenguaje();
        model.addAttribute("lenguajes", lenguajes);
        return "index";
    }
    @RequestMapping("/lenguajes/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Lenguaje lenguaje = lenguajeService.findLenguaje(id);
        model.addAttribute("lenguaje", lenguaje);
        return "edit"; //edit
    }
    @RequestMapping(value="/lenguajes/{id}", method=RequestMethod.PUT)
    public String update(@Validated @ModelAttribute("lenguaje")Lenguaje lenguaje, BindingResult result) {
        if (result.hasErrors()) {
            return "index";
        } else {
            //lenguajeService.updateLenguaje(lenguaje.getId(), lenguaje.getName(), lenguaje.getCreator(), lenguaje.getVersion());
            return "redirect:/lenguajes";//redirect:/lenguajes
        }
    }
    @RequestMapping(value="/lenguajes/{id}/delete", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id, @RequestParam(value="aux") String aux) {
    	if(aux.equals("_method")) {
    		lenguajeService.deleteLenguaje(id);
    		 return "redirect:/lenguajes";
    	}
    	return "index"; //edit
    	
    }
}