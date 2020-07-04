package com.example.demo;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContadorController {

	@RequestMapping("")
	public String home(HttpSession newSession) {
		
		if(newSession.getAttribute("contador") == null) {
			newSession.setAttribute("contador", 0);
		}else {
			int contador = (int) newSession.getAttribute("contador")+1;
			newSession.setAttribute("contador", contador);
		}
		
		return "home.jsp";
	}
	@RequestMapping("/counter")
	public String counter(HttpSession newSession, Model model, @RequestParam(value="inicial", required = false)String action) {
		if (action != null) {
			newSession.setAttribute("contador",0);
			return "redirect:/counter";
		}
		model.addAttribute("contador",newSession.getAttribute("contador"));
		return "count.jsp";
	
	}
}
