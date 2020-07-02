package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	@RequestMapping("/")
	public String greeting(@RequestParam(value="name",required = false) String searchQuery) {
		
		String cadena = "Welcome to SpringBoot!";
		
		if(searchQuery == null) {
			return cadena + " Hello Human!";
		}else {
			return cadena +" Hello " + searchQuery;
		}
		
	}
}
