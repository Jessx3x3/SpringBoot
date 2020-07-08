package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class EncuestaController {

	@RequestMapping("")
	public String home() {
		
		return "home";
	}
	
	@RequestMapping(value="/index", method = RequestMethod.POST)
	public String index(Model model, @ModelAttribute("information")Information information, BindingResult result) {
		
		if(result.hasErrors()) {
			return "error";
		}
		
		model.addAttribute("name", information.getName());
		model.addAttribute("location", information.getLocation());
		model.addAttribute("language", information.getLanguage());
		model.addAttribute("comment", information.getComment());

		return "index";

	}
	
	@RequestMapping("back")
	public String back() {
		
		return "home";
	}


}
