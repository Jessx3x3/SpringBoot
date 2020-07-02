package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CadenasApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadenasApplication.class, args);
	}
	@RequestMapping("/")
	public String firstMessage() {
		return "Hello client! How are you doing?";
	}
	@RequestMapping("/random")
	public String secondMessage() {
		return "Spring Boot is great! So easy to just respond with strings";
	}
}
