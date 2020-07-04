package com.example.demo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home(){
		return "home.jsp";
	}
	@RequestMapping("/date")
	public String date(Model model){
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDateTime now = LocalDateTime.now();
		
		String date = dtf.format(now);
		
		model.addAttribute("date", date);
		
		return "newDate.jsp";
	}
	@RequestMapping("/time")
	public String time(Model model){
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		
		String time = dtf.format(now);
		
		
		model.addAttribute("time", time);
		
		return "newTime.jsp";
	}
}
