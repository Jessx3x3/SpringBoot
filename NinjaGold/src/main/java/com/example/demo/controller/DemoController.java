package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Data;
import com.example.demo.model.Ninja;

@Controller
public class DemoController {
	Ninja ninja = new Ninja();
	
	@RequestMapping("")
	public String home(Model model) {
		model.addAttribute("gold", 0);
		return "index";
	}

	@RequestMapping(value="gold", method = RequestMethod.POST)
	public String goldValues(@RequestParam(value="aux") String aux, Model model) {
		
		Data data = new Data();
		
		if(aux.equals("farm")) {
			data.farmActivity(ninja);
			model.addAttribute("gold", ninja.getGold());
		}
		if(aux.equals("cave")) {
			data.caveActivity(ninja);
			model.addAttribute("gold", ninja.getGold());
		}
		if(aux.equals("house")) {
			data.houseActivity(ninja);
			model.addAttribute("gold", ninja.getGold());
		}
		if(aux.equals("casino")) {
			data.casinoActivity(ninja);
			model.addAttribute("gold", ninja.getGold());
		}
		
		for(String s: data.getActivities()) {
			model.addAttribute("activities", s);
		}
			
		return "index";
	}
}
