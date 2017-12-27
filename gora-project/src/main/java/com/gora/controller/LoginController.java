package com.gora.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gora.model.UserModel;

@Controller
public class LoginController {

	UserModel userModel = new UserModel();
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String showLoginPage(Model model) {
	
		model.addAttribute("userModel", userModel);
		return "login";
	}
	

	
	
}
