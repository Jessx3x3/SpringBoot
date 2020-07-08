package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CodigoController {

	@RequestMapping("")
    public String home() {
		
        return "home.jsp";
    }

	@RequestMapping(value="/index", method=RequestMethod.POST)
	public String index(Model model, @ModelAttribute("user")User user, BindingResult result){
		
		String code = "Bushido";
		String mensaje = "You must train harder!";
		
		if(result.hasErrors()) {
			return "error";
		}
		
		model.addAttribute("pass", user.getPass());
		model.addAttribute("msg", mensaje);
		
		if(user.getPass().equals(code)) {
			return "code.jsp";
		}else {	
			return "home.jsp";
		}
		
	}

}
